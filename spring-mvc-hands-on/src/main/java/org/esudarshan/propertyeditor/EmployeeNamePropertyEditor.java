package org.esudarshan.propertyeditor;

import java.beans.PropertyEditorSupport;

public class EmployeeNamePropertyEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String name) throws IllegalArgumentException {
		super.setAsText("Mr. " + name);
	}
}
