
package com.shortenUrl.controllers;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.List;
import org.springframework.validation.FieldError;

/**
 *
 * @author abdalrahman.sharawy
 */
@JsonSerialize
public class JsonResponse { 
private String msg;
private Object result;
private List<FieldError> errors;

  public List<FieldError> getErrors() {
    return errors;
  }

  public void setErrors(List<FieldError> errors) {
    this.errors = errors;
  }
  public JsonResponse() {
    this.msg = null;
    this.result = null;
  }
  public JsonResponse(String msg) {
    this.msg = msg;
    this.result = null;
  }

  public Object getResult() {
    return result;
  }

  public void setResult(Object object) {
    this.result = object;
  }
  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

}

