/*
 * Copyright 2002-2007 the original author or authors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */ 

package org.springframework.ide.eclipse.beans.core.internal.model;

import org.springframework.ide.eclipse.beans.core.model.IBean;
import org.springframework.ide.eclipse.beans.core.model.IBeanReference;
import org.springframework.ide.eclipse.beans.core.model.IBeansModelElementTypes;
import org.springframework.ide.eclipse.core.model.ISourceModelElement;
import org.springframework.util.ObjectUtils;

/**
 * Holds a reference to an {@link IBean}'s by it's name.
 * 
 * @author Torsten Juergeleit
 */
public class BeanReference extends AbstractBeansModelElement implements
		IBeanReference {

	private String beanName;

	public BeanReference(ISourceModelElement parent,
			org.springframework.beans.factory.config.BeanReference beanRef) {
		super(parent, "(bean reference)", beanRef);
		beanName = beanRef.getBeanName();
	}

	public int getElementType() {
		return IBeansModelElementTypes.BEAN_REFERENCE_TYPE;
	}

	public String getBeanName() {
		return beanName;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof BeanReference)) {
			return false;
		}
		BeanReference that = (BeanReference) other;
		if (!ObjectUtils.nullSafeEquals(this.beanName, that.beanName)) return false;
		return super.equals(other);
	}

	public int hashCode() {
		int hashCode = ObjectUtils.nullSafeHashCode(beanName);
		return getElementType() * hashCode + super.hashCode();
	}

	public String toString() {
		StringBuffer text = new StringBuffer(super.toString());
		text.append(": name=");
		text.append(beanName);
		return text.toString();
	}
}
