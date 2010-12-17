package edu.kit.iism.experimentcenter;

import java.beans.PropertyEditorSupport;
import java.util.Date;

public class CustomDateBinder extends PropertyEditorSupport {

  @Override
  public void setAsText(String s) throws IllegalArgumentException {
    if (s != null && !s.equals("")) {
      Long longValue = Long.valueOf(s);
      setValue(new Date(longValue));
    }
  }
}
