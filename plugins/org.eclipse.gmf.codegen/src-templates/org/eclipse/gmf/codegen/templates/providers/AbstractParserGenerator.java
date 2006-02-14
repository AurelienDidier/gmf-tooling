package org.eclipse.gmf.codegen.templates.providers;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

public class AbstractParserGenerator
{
  protected static String nl;
  public static synchronized AbstractParserGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    AbstractParserGenerator result = new AbstractParserGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL;
  protected final String TEXT_3 = NL + "import java.text.MessageFormat;" + NL + "import java.text.ParsePosition;" + NL + "" + NL + "import org.eclipse.core.runtime.IAdaptable;" + NL + "import org.eclipse.emf.ecore.EClassifier;" + NL + "import org.eclipse.emf.ecore.EDataType;" + NL + "import org.eclipse.emf.ecore.EEnum;" + NL + "import org.eclipse.emf.ecore.EEnumLiteral;" + NL + "import org.eclipse.emf.ecore.EObject;" + NL + "import org.eclipse.emf.ecore.EStructuralFeature;" + NL + "import org.eclipse.emf.transaction.TransactionalEditingDomain;" + NL + "import org.eclipse.gmf.runtime.common.core.command.ICommand;" + NL + "import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;" + NL + "import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;" + NL + "import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;" + NL + "import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;" + NL + "import org.eclipse.jface.text.contentassist.IContentAssistProcessor;";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public abstract class ";
  protected final String TEXT_5 = " implements IParser {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate TransactionalEditingDomain editingDomain;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate String viewPattern;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate MessageFormat viewProcessor;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate String editPattern;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate MessageFormat editProcessor;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic TransactionalEditingDomain getEditingDomain() {" + NL + "\t\treturn editingDomain;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void setEditingDomain(TransactionalEditingDomain editingDomain) {" + NL + "\t\tthis.editingDomain = editingDomain;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic String getViewPattern() {" + NL + "\t\treturn viewPattern;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected MessageFormat getViewProcessor() {" + NL + "\t\treturn viewProcessor;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void setViewPattern(String viewPattern) {" + NL + "\t\tthis.viewPattern = viewPattern;" + NL + "\t\tviewProcessor = createViewProcessor(viewPattern);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected MessageFormat createViewProcessor(String viewPattern) {" + NL + "\t\treturn new MessageFormat(viewPattern);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic String getEditPattern() {" + NL + "\t\treturn editPattern;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected MessageFormat getEditProcessor() {" + NL + "\t\treturn editProcessor;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void setEditPattern(String editPattern) {" + NL + "\t\tthis.editPattern = editPattern;" + NL + "\t\teditProcessor = createEditProcessor(editPattern);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected MessageFormat createEditProcessor(String editPattern) {" + NL + "\t\treturn new MessageFormat(editPattern);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic String getPrintString(IAdaptable adapter, int flags) {" + NL + "\t\treturn getStringByPattern(adapter, flags, getViewPattern(), getViewProcessor());" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic String getEditString(IAdaptable adapter, int flags) {" + NL + "\t\treturn getStringByPattern(adapter, flags, getEditPattern(), getEditProcessor());" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected abstract String getStringByPattern(IAdaptable adapter, int flags, String pattern, MessageFormat processor);" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic IParserEditStatus isValidEditString(IAdaptable element, String editString) {" + NL + "\t\tParsePosition pos = new ParsePosition(0);" + NL + "\t\tObject[] values = getEditProcessor().parse(editString, pos);" + NL + "\t\tif (values == null) {" + NL + "\t\t\treturn new ParserEditStatus(";
  protected final String TEXT_6 = ".ID," + NL + "\t\t\t\tIParserEditStatus.UNEDITABLE, \"Invalid input at \" + pos.getErrorIndex());" + NL + "\t\t}" + NL + "\t\treturn validateNewValues(values);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected IParserEditStatus validateNewValues(Object[] values) {" + NL + "\t\treturn ParserEditStatus.EDITABLE_STATUS;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ICommand getParseCommand(IAdaptable adapter, String newString, int flags) {" + NL + "\t\tObject[] values = getEditProcessor().parse(newString, new ParsePosition(0));" + NL + "\t\tif (values == null || validateNewValues(values).getCode() != IParserEditStatus.EDITABLE) {" + NL + "\t\t\treturn UnexecutableCommand.INSTANCE;" + NL + "\t\t}" + NL + "\t\treturn getParseCommand(adapter, values);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected abstract ICommand getParseCommand(IAdaptable adapter, Object[] values);" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic IContentAssistProcessor getCompletionProcessor(IAdaptable element) {" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ICommand getModificationCommand(EObject element, EStructuralFeature feature, Object value) {" + NL + "\t\tvalue = getValidNewValue(feature, value);" + NL + "\t\tif (value instanceof InvalidValue) {" + NL + "\t\t\treturn UnexecutableCommand.INSTANCE;" + NL + "\t\t}" + NL + "\t\tSetRequest request = new SetRequest(element, feature, value);" + NL + "\t\treturn new SetValueCommand(request);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Object getValidValue(EStructuralFeature feature, Object value) {" + NL + "\t\tEClassifier type = feature.getEType();" + NL + "\t\tif (type instanceof EDataType) {" + NL + "\t\t\tClass iClass = type.getInstanceClass();" + NL + "\t\t\tif (String.class.equals(iClass)) {" + NL + "\t\t\t\tif (value == null) {" + NL + "\t\t\t\t\tvalue = \"\";" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn value;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Object getValidNewValue(EStructuralFeature feature, Object value) {" + NL + "\t\tEClassifier type = feature.getEType();" + NL + "\t\tif (type instanceof EDataType) {" + NL + "\t\t\tClass iClass = type.getInstanceClass();" + NL + "\t\t\tif (Boolean.TYPE.equals(iClass)) {" + NL + "\t\t\t\tif (value instanceof Boolean) {" + NL + "\t\t\t\t\t// ok" + NL + "\t\t\t\t} else if (value instanceof String) {" + NL + "\t\t\t\t\tvalue = Boolean.valueOf((String) value);" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\tvalue = new InvalidValue(\"Value of type Boolean is expected\");" + NL + "\t\t\t\t}" + NL + "\t\t\t} else if (Character.TYPE.equals(iClass)) {" + NL + "\t\t\t\tif (value instanceof Character) {" + NL + "\t\t\t\t\t// ok" + NL + "\t\t\t\t} else if (value instanceof String) {" + NL + "\t\t\t\t\tString s = (String) value;" + NL + "\t\t\t\t\tif (s.length() == 0) {" + NL + "\t\t\t\t\t\tvalue = null;" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\tvalue = new Character(s.charAt(0));" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\tvalue = new InvalidValue(\"Value of type Character is expected\");" + NL + "\t\t\t\t}" + NL + "\t\t\t} else if (Byte.TYPE.equals(iClass)) {" + NL + "\t\t\t\tif (value instanceof Byte) {" + NL + "\t\t\t\t\t// ok" + NL + "\t\t\t\t} else if (value instanceof Number) {" + NL + "\t\t\t\t\tvalue = new Byte(((Number) value).byteValue());" + NL + "\t\t\t\t} else if (value instanceof String) {" + NL + "\t\t\t\t\tString s = (String) value;" + NL + "\t\t\t\t\tif (s.length() == 0) {" + NL + "\t\t\t\t\t\tvalue = null;" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t\tvalue = Byte.valueOf(s);" + NL + "\t\t\t\t\t\t} catch (NumberFormatException nfe) {" + NL + "\t\t\t\t\t\t\tvalue = new InvalidValue(\"String value does not convert to Byte value\");" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\tvalue = new InvalidValue(\"Value of type Byte is expected\");" + NL + "\t\t\t\t}" + NL + "\t\t\t} else if (Short.TYPE.equals(iClass)) {" + NL + "\t\t\t\tif (value instanceof Short) {" + NL + "\t\t\t\t\t// ok" + NL + "\t\t\t\t} else if (value instanceof Number) {" + NL + "\t\t\t\t\tvalue = new Short(((Number) value).shortValue());" + NL + "\t\t\t\t} else if (value instanceof String) {" + NL + "\t\t\t\t\tString s = (String) value;" + NL + "\t\t\t\t\tif (s.length() == 0) {" + NL + "\t\t\t\t\t\tvalue = null;" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t\tvalue = Short.valueOf(s);" + NL + "\t\t\t\t\t\t} catch (NumberFormatException nfe) {" + NL + "\t\t\t\t\t\t\tvalue = new InvalidValue(\"String value does not convert to Short value\");" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\tvalue = new InvalidValue(\"Value of type Short is expected\");" + NL + "\t\t\t\t}" + NL + "\t\t\t} else if (Integer.TYPE.equals(iClass)) {" + NL + "\t\t\t\tif (value instanceof Integer) {" + NL + "\t\t\t\t\t// ok" + NL + "\t\t\t\t} else if (value instanceof Number) {" + NL + "\t\t\t\t\tvalue = new Integer(((Number) value).intValue());" + NL + "\t\t\t\t} else if (value instanceof String) {" + NL + "\t\t\t\t\tString s = (String) value;" + NL + "\t\t\t\t\tif (s.length() == 0) {" + NL + "\t\t\t\t\t\tvalue = null;" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t\tvalue = Integer.valueOf(s);" + NL + "\t\t\t\t\t\t} catch (NumberFormatException nfe) {" + NL + "\t\t\t\t\t\t\tvalue = new InvalidValue(\"String value does not convert to Integer value\");" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\tvalue = new InvalidValue(\"Value of type Integer is expected\");" + NL + "\t\t\t\t}" + NL + "\t\t\t} else if (Long.TYPE.equals(iClass)) {" + NL + "\t\t\t\tif (value instanceof Long) {" + NL + "\t\t\t\t\t// ok" + NL + "\t\t\t\t} else if (value instanceof Number) {" + NL + "\t\t\t\t\tvalue = new Long(((Number) value).longValue());" + NL + "\t\t\t\t} else if (value instanceof String) {" + NL + "\t\t\t\t\tString s = (String) value;" + NL + "\t\t\t\t\tif (s.length() == 0) {" + NL + "\t\t\t\t\t\tvalue = null;" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t\tvalue = Long.valueOf(s);" + NL + "\t\t\t\t\t\t} catch (NumberFormatException nfe) {" + NL + "\t\t\t\t\t\t\tvalue = new InvalidValue(\"String value does not convert to Long value\");" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\tvalue = new InvalidValue(\"Value of type Long is expected\");" + NL + "\t\t\t\t}" + NL + "\t\t\t} else if (Float.TYPE.equals(iClass)) {" + NL + "\t\t\t\tif (value instanceof Float) {" + NL + "\t\t\t\t\t// ok" + NL + "\t\t\t\t} else if (value instanceof Number) {" + NL + "\t\t\t\t\tvalue = new Float(((Number) value).floatValue());" + NL + "\t\t\t\t} else if (value instanceof String) {" + NL + "\t\t\t\t\tString s = (String) value;" + NL + "\t\t\t\t\tif (s.length() == 0) {" + NL + "\t\t\t\t\t\tvalue = null;" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t\tvalue = Float.valueOf(s);" + NL + "\t\t\t\t\t\t} catch (NumberFormatException nfe) {" + NL + "\t\t\t\t\t\t\tvalue = new InvalidValue(\"String value does not convert to Float value\");" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\tvalue = new InvalidValue(\"Value of type Float is expected\");" + NL + "\t\t\t\t}" + NL + "\t\t\t} else if (Double.TYPE.equals(iClass)) {" + NL + "\t\t\t\tif (value instanceof Double) {" + NL + "\t\t\t\t\t// ok" + NL + "\t\t\t\t} else if (value instanceof Number) {" + NL + "\t\t\t\t\tvalue = new Double(((Number) value).doubleValue());" + NL + "\t\t\t\t} else if (value instanceof String) {" + NL + "\t\t\t\t\tString s = (String) value;" + NL + "\t\t\t\t\tif (s.length() == 0) {" + NL + "\t\t\t\t\t\tvalue = null;" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t\tvalue = Double.valueOf(s);" + NL + "\t\t\t\t\t\t} catch (NumberFormatException nfe) {" + NL + "\t\t\t\t\t\t\tvalue = new InvalidValue(\"String value does not convert to Double value\");" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\tvalue = new InvalidValue(\"Value of type Double is expected\");" + NL + "\t\t\t\t}" + NL + "\t\t\t} else if (type instanceof EEnum) {" + NL + "\t\t\t\tif (value instanceof String) {" + NL + "\t\t\t\t\tEEnumLiteral literal = ((EEnum) type).getEEnumLiteralByLiteral((String) value);" + NL + "\t\t\t\t\tif (literal == null) {" + NL + "\t\t\t\t\t\tvalue = new InvalidValue(\"Unknown literal: \" + value);" + NL + "\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\tvalue = literal.getInstance();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\tvalue = new InvalidValue(\"Value of type String is expected\");" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn value;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected class InvalidValue {" + NL + "" + NL + "\t\tprivate String description;" + NL + "" + NL + "\t\tpublic InvalidValue(String description) {" + NL + "\t\t\tthis.description = description;" + NL + "\t\t}" + NL + "" + NL + "\t\tpublic String toString() {" + NL + "\t\t\treturn description;" + NL + "\t\t}" + NL + "\t}" + NL + "}";
  protected final String TEXT_7 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    GenDiagram genDiagram = (GenDiagram) ((Object[]) argument)[0];
    stringBuffer.append(TEXT_1);
    stringBuffer.append(genDiagram.getProvidersPackageName());
    stringBuffer.append(TEXT_2);
    ImportUtil importManager = new ImportUtil(genDiagram.getProvidersPackageName());
    stringBuffer.append(TEXT_3);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genDiagram.getAbstractParserClassName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_6);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_7);
    return stringBuffer.toString();
  }
}
