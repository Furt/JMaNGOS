/*******************************************************************************
 * Copyright (c) 2012 JMANGOS
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *     JMANGOS - initial API and implementation
 ******************************************************************************/
package org.JMANGOS.wowdata.dbc.dataholder;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;

public abstract class DBCStruct<T extends DBCStruct<T>> extends DBCBaseStruct
		implements Iterable<T>, Iterator<T>, Cloneable {
	private int count;
	private int skiplenght = 0;
	private int currposition = 0;
	private Object[] FiledsName;
	private boolean mode;

	@SuppressWarnings("unchecked")
	@Override
	protected <M extends Member> M[] array(M[] param) {
		if (param.length > 0) {
			if (INTERNALSTRING.isInstance(param)) {
				for (int i = 0; i < param.length;) {
					param[i++] = (M) new InternalString();
				}
				return param;
			} else
				return super.array(param);
		}
		else return null;
	}

	@SuppressWarnings("unchecked")
	public T LookupEntry(int i) {
		setCurrposition(i);
		setByteBufferPosition(HEADER_SIZE + (size() + skiplenght) * i);
		return (T) this;
	}

	public final void setStringBufferPosition(int stringBufPos) {
		this.stringBufPos = stringBufPos;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T clone() {
		T re = null;
		try {
			re = (T) this.getClass().newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		re.setByteBuffer(getByteBuffer(), getByteBufferPosition());
		re.setStringBufferPosition(stringBufPos);
		return re;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getSkiplenght() {
		return skiplenght;
	}

	public void setSkipLenght(int skiplenght) {
		this.skiplenght = skiplenght;
	}

	@Override
	public boolean hasNext() {
		return (currposition + 1) < getCount();
	}

	@Override
	public T next() {
		if (hasNext()) {
			return LookupEntry(currposition + 1);
		}
		return null;
	}

	@Override
	public void remove() {

	}

	public void saveToXML(String path, boolean full) throws IOException {
		this.mode = full;
		Writer out = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(path + this.getClass().getSimpleName()
						+ ".xml"), "UTF-8"));
		try {
			String header = this.getClass().getSimpleName() + "List";
			cacheFields(full);
			out
					.write("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n");
			out.write("<" + header + ">\n");
			toXML(out);
			out.write("</" + header + ">");
			out.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
	}

	public void cacheFields( boolean mode) {
		Field[] f = this.getClass().getFields();
		List<String> TFiledsName = new ArrayList<String>();
		for (int i = 0; i < f.length; i++) {
			if (Modifier.isStatic(f[i].getModifiers())
					|| !f[i].isAnnotationPresent(XmlAttribute.class)) {
				continue;
			}
			XmlAttribute property = f[i].getAnnotation(XmlAttribute.class);
			if (property.name() != null & (property.required() | mode)) {
				try {
					if (f[i].getType().isArray()) {
						Object sd = f[i].get(this);
						for (int j = 0; j < Array.getLength(sd); j++) {
							TFiledsName.add(property.name() + (j + 1));
						}
					} else if (f[i].getType() == InternalString.class
							|| f[i].getType() == MultiInternalString.class) {
						if (mode)
							TFiledsName.add(property.name());
					} else {
						TFiledsName.add(property.name());
					}
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}

			}
		}
		;
		FiledsName = TFiledsName.toArray();
	}

	public void toXML(Writer out) throws IOException {
		Field[] f = this.getClass().getFields();
		int counter = 0;
		do {
			out.write("\t<" + this.getClass().getSimpleName() + " ");
			for (int i = 0; i < f.length; i++) {
				if (Modifier.isStatic(f[i].getModifiers())
						|| !f[i].isAnnotationPresent(XmlAttribute.class)) {
					continue;
				}
				XmlAttribute property = f[i].getAnnotation(XmlAttribute.class);
				if (property.name() != null & (property.required() | mode)) {
					try {
						if (f[i].getType() == InternalString.class
								|| f[i].getType() == MultiInternalString.class) {
							if (mode) {
								String escapedString = escapeCharacters((f[i]
										.get(this)).toString());
								if ((escapedString.length() > 0)
										| property.required()) {
									writeAttr((String) FiledsName[counter],
											escapedString, out);
								}
								counter++;
							}
						} else if (f[i].getType().isArray()) {
							Object sd = f[i].get(this);
							for (int j = 0; j < Array.getLength(sd); j++) {
								Array.get(sd, j);
								writeAttr((String) FiledsName[counter++], Array
										.get(sd, j).toString(), out);
							}
						} else {
							writeAttr((String) FiledsName[counter++], f[i].get(
									this).toString(), out);
						}

					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}

				}
			}
			out.write("/>\n");
			counter = 0;
		} while (this.next() != null);
	}

	public void writeAttr(String name, String value, Writer out)
			throws IOException {
		out.write(name + "=\"" + value + "\" ");
	}

	public String escapeCharacters(String str) {
		if (str == null)
			return "";
		StringBuffer s = new StringBuffer(str);
		for (int i = 0; i < s.length(); i++)
			switch (s.charAt(i)) {
			case '\"':
				s = s.replace(i++, i, "&quot;");
				break;
			case '&':
				s = s.replace(i++, i, "&amp;");
				break;
			case '<':
				s = s.replace(i++, i, "&lt;");
				break;
			case '>':
				s = s.replace(i++, i, "&gt;");
				break;
			case '\'':
				s = s.replace(i++, i, "&apos;");
				break;
			default:
				break;
			}
		return s.toString();
	}

	public void setCurrposition(int currposition) {
		this.currposition = currposition;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T iterator() {
		return (T) this;
	}
}
