/**
 * Copyright (C) 2019 Linghui Luo 
 * 
 * This library is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as 
 * published by the Free Software Foundation, either version 2.1 of the 
 * License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 * 
 */

package cova.source.data;

import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import soot.jimple.infoflow.data.SootMethodAndClass;

/**
 * The Class SourceUICallback represents a source API that is callback.
 */
public class SourceUICallback extends Source {

  /** The method implements the callback */
  private SootMethodAndClass method;

  /** The callback. */
  private SootMethodAndClass callback;

  private Pattern methodPattern;
  private Pattern callbackPattern;

  /**
   * Instantiates a new source UI callback.
   *
   * @param method
   *          the method implements the callback.
   * @param callback
   *          the callback
   * @param id
   *          the id
   */
  public SourceUICallback(SootMethodAndClass method, SootMethodAndClass callback, int id) {
    this(callback, id);
    this.method = method;
  }

  /**
   * Instantiates a new source UI callback.
   *
   * @param parent
   *          the parent
   * @param id
   *          the id
   */
  public SourceUICallback(SootMethodAndClass callback, int id) {
    super(SourceType.U, callback.getMethodName(), id);
    this.callback = callback;
  }

  /**
   * Gets the method.
   *
   * @return the method
   */
  public SootMethodAndClass getMethod() {
    return method;
  }

  /**
   * Gets the callback.
   *
   * @return the callback
   */
  public SootMethodAndClass getCallback() {
    return callback;
  }

  public Pattern getMethodPattern() {
    if (methodPattern == null) {
      String regex = ".*" + method.getSignature();
      String[] searchList = new String[] { "(", ")", "$", "[", "]" };
      String[] replaceList = new String[] { "\\(", "\\)", "\\$", "\\[", "\\]" };
      regex = StringUtils.replaceEach(regex, searchList, replaceList);
      methodPattern = Pattern.compile(regex);
    }
    return methodPattern;

  }

  public Pattern getCallbackPattern() {
    if (callbackPattern == null) {
      String regex = ".*" + callback.getSignature();
      String[] searchList = new String[] { "(", ")", "$", "[", "]" };
      String[] replaceList = new String[] { "\\(", "\\)", "\\$", "\\[", "\\]" };
      regex = StringUtils.replaceEach(regex, searchList, replaceList);
      callbackPattern = Pattern.compile(regex);
    }
    return callbackPattern;
  }

  @Override
  public String getSignature() {
    return this.callback.getSignature();
  }
}