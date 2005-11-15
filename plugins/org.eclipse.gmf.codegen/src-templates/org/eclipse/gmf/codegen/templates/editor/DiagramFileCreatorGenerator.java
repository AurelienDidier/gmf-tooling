package org.eclipse.gmf.codegen.templates.editor;

import org.eclipse.gmf.codegen.gmfgen.*;

public class DiagramFileCreatorGenerator
{
  protected static String nl;
  public static synchronized DiagramFileCreatorGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    DiagramFileCreatorGenerator result = new DiagramFileCreatorGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL + "" + NL + "import org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide.util.IDEEditorFileCreator;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.resources.editor.util.DiagramFileCreator;" + NL + "" + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class DiagramFileCreatorBis extends IDEEditorFileCreator {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static DiagramFileCreatorBis INSTANCE = new DiagramFileCreatorBis();" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static DiagramFileCreator getInstance() {" + NL + "\t\treturn INSTANCE;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic String getExtension() {" + NL + "\t\treturn \".";
  protected final String TEXT_3 = "\"; //$NON-NLS-1$" + NL + "\t}" + NL + "}";
  protected final String TEXT_4 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    GenDiagram genDiagram = (GenDiagram) argument;
    stringBuffer.append(TEXT_1);
    stringBuffer.append(genDiagram.getEditorPackageName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(genDiagram.getDiagramFileExtension());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(TEXT_4);
    return stringBuffer.toString();
  }
}
