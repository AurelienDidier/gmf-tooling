package org.eclipse.gmf.codegen.templates.providers;

import java.util.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

public class ParserProviderGenerator
{
  protected static String nl;
  public static synchronized ParserProviderGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    ParserProviderGenerator result = new ParserProviderGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL;
  protected final String TEXT_3 = NL + "import java.util.Map;" + NL + "import java.util.WeakHashMap;" + NL + "" + NL + "import org.eclipse.core.runtime.IAdaptable;" + NL + "import org.eclipse.emf.ecore.EObject;" + NL + "import org.eclipse.emf.transaction.TransactionalEditingDomain;" + NL + "import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;" + NL + "import org.eclipse.gmf.runtime.common.core.service.IOperation;" + NL + "import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;" + NL + "import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;" + NL + "import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.IElementType;";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_5 = " extends AbstractProvider implements IParserProvider {";
  protected final String TEXT_6 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate Map ";
  protected final String TEXT_7 = ";" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate IParser get";
  protected final String TEXT_8 = "(TransactionalEditingDomain editingDomain) {" + NL + "\t\tif (";
  protected final String TEXT_9 = " == null) {" + NL + "\t\t\t";
  protected final String TEXT_10 = " = new WeakHashMap();" + NL + "\t\t}" + NL + "\t\tIParser parser = (IParser) ";
  protected final String TEXT_11 = ".get(editingDomain);" + NL + "\t\tif (parser == null) {" + NL + "\t\t\tparser = create";
  protected final String TEXT_12 = "(editingDomain);" + NL + "\t\t\t";
  protected final String TEXT_13 = ".put(editingDomain, parser);" + NL + "\t\t}" + NL + "\t\treturn parser;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected IParser create";
  protected final String TEXT_14 = "(TransactionalEditingDomain editingDomain) {";
  protected final String TEXT_15 = NL + "\t\t";
  protected final String TEXT_16 = " parser = new ";
  protected final String TEXT_17 = "(";
  protected final String TEXT_18 = ".eINSTANCE.get";
  protected final String TEXT_19 = "().getEStructuralFeature(\"";
  protected final String TEXT_20 = "\"));";
  protected final String TEXT_21 = NL + "\t\t";
  protected final String TEXT_22 = " features = new ";
  protected final String TEXT_23 = "(";
  protected final String TEXT_24 = ");";
  protected final String TEXT_25 = NL + "\t\tfeatures.add(";
  protected final String TEXT_26 = ".eINSTANCE.get";
  protected final String TEXT_27 = "().getEStructuralFeature(\"";
  protected final String TEXT_28 = "\"));";
  protected final String TEXT_29 = NL + "\t\t";
  protected final String TEXT_30 = " parser = new ";
  protected final String TEXT_31 = "(features);";
  protected final String TEXT_32 = NL + "\t\tparser.setViewPattern(\"";
  protected final String TEXT_33 = "\");";
  protected final String TEXT_34 = NL + "\t\tparser.setEditPattern(\"";
  protected final String TEXT_35 = "\");";
  protected final String TEXT_36 = NL + "\t\tparser.setEditingDomain(editingDomain);" + NL + "\t\treturn parser;" + NL + "\t}";
  protected final String TEXT_37 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected IParser getParser(IElementType type, String viewType, TransactionalEditingDomain editingDomain) {";
  protected final String TEXT_38 = NL + "\t\tif (";
  protected final String TEXT_39 = ".";
  protected final String TEXT_40 = " == type) {";
  protected final String TEXT_41 = NL + "\t\t\treturn get";
  protected final String TEXT_42 = "(editingDomain);";
  protected final String TEXT_43 = NL + "\t\t\tif (";
  protected final String TEXT_44 = ".";
  protected final String TEXT_45 = "Labels.";
  protected final String TEXT_46 = ".equals(viewType)) {" + NL + "\t\t\t\treturn get";
  protected final String TEXT_47 = "(editingDomain);" + NL + "\t\t\t}";
  protected final String TEXT_48 = NL + "\t\t}";
  protected final String TEXT_49 = NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic IParser getParser(IAdaptable hint) {" + NL + "\t\tString viewType = (String) hint.getAdapter(String.class);" + NL + "\t\tIElementType type = (IElementType) hint.getAdapter(IElementType.class);" + NL + "\t\tif (type == null) {" + NL + "\t\t\tEObject element = (EObject) hint.getAdapter(EObject.class);" + NL + "\t\t\ttype = ElementTypeRegistry.getInstance().getElementType(element);" + NL + "\t\t}" + NL + "\t\tTransactionalEditingDomain editingDomain = (TransactionalEditingDomain) hint.getAdapter(TransactionalEditingDomain.class);" + NL + "\t\treturn getParser(type, viewType, editingDomain);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic boolean provides(IOperation operation) {" + NL + "\t\tif (operation instanceof GetParserOperation) {" + NL + "\t\t\treturn getParser(((GetParserOperation) operation).getHint()) != null;" + NL + "\t\t}" + NL + "\t\treturn false;" + NL + "\t}" + NL + "}";
  protected final String TEXT_50 = NL;

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
    stringBuffer.append(genDiagram.getParserProviderClassName());
    stringBuffer.append(TEXT_5);
    
Map labels = new LinkedHashMap(); // Gen[Node|Link] -> List : GenLabel
Map labelMethodNames = new HashMap(); // GenLabel -> String
for (Iterator contents = genDiagram.eAllContents(); contents.hasNext(); ) {
	Object next = contents.next();
	if (next instanceof GenLabel) {
		GenLabel genLabel = (GenLabel) next;
		GenCommonBase genHost;
		String accessorName;
		if (genLabel instanceof GenNodeLabel) {
			genHost = ((GenNodeLabel) genLabel).getNode();
			accessorName = ((GenNode) genHost).getDomainMetaClass().getClassifierAccessorName();
		} else if (genLabel instanceof GenLinkLabel) {
			genHost = ((GenLinkLabel) genLabel).getLink();
			LinkModelFacet linkModelFacet = ((GenLink) genHost).getModelFacet();
			if (linkModelFacet instanceof TypeLinkModelFacet) {
				accessorName = ((TypeLinkModelFacet) linkModelFacet).getMetaClass().getClassifierAccessorName();
			} else {
				accessorName = ((FeatureModelFacet) linkModelFacet).getMetaFeature().getGenClass().getClassifierAccessorName();
			}
		} else {
			throw new IllegalArgumentException("Unknown label type: " + genLabel);
		}
		LabelModelFacet modelFacet = genLabel.getModelFacet();
		if (modelFacet == null || modelFacet instanceof TextLabelModelFacet) {
			continue; // custom parser
		}
		List labelsList = (List) labels.get(genHost);
		if (labelsList == null) {
			labelsList = new ArrayList();
			labels.put(genHost, labelsList);
		}
		labelsList.add(genLabel);
		String baseName = genHost.getClassNamePrefix() + genLabel.getSemanticHintFieldName();
		char c = baseName.charAt(0);
		baseName = baseName.substring(1) + "Parser";
		String fieldName = Character.toLowerCase(c) + baseName + 's';
		String methodName = Character.toUpperCase(c) + baseName;
		labelMethodNames.put(genLabel, methodName);

    stringBuffer.append(TEXT_6);
    stringBuffer.append(fieldName);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(methodName);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(fieldName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(fieldName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(fieldName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(methodName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(fieldName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(methodName);
    stringBuffer.append(TEXT_14);
    
		String parserClassName;
		String viewPattern;
		String editPattern;
		if (modelFacet instanceof FeatureLabelModelFacet) {
			parserClassName = importManager.getImportedName(genDiagram.getStructuralFeatureParserQualifiedClassName());
			String featureName = ((FeatureLabelModelFacet) modelFacet).getMetaFeature().getName();
			viewPattern = ((FeatureLabelModelFacet) modelFacet).getViewPattern();
			editPattern = ((FeatureLabelModelFacet) modelFacet).getEditPattern();
			String semanticPackageInterfaceName = importManager.getImportedName(((FeatureLabelModelFacet) modelFacet).getMetaFeature().getGenPackage().getQualifiedPackageInterfaceName());

    stringBuffer.append(TEXT_15);
    stringBuffer.append(parserClassName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(parserClassName);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(accessorName);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(featureName);
    stringBuffer.append(TEXT_20);
    
		} else if (modelFacet instanceof CompositeFeatureLabelModelFacet) {
			parserClassName = importManager.getImportedName(genDiagram.getStructuralFeaturesParserQualifiedClassName());
			List features = ((CompositeFeatureLabelModelFacet) modelFacet).getMetaFeatures();
			viewPattern = ((CompositeFeatureLabelModelFacet) modelFacet).getViewPattern();
			editPattern = ((CompositeFeatureLabelModelFacet) modelFacet).getEditPattern();

    stringBuffer.append(TEXT_21);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(features.size());
    stringBuffer.append(TEXT_24);
    
			for (java.util.Iterator it = features.iterator(); it.hasNext(); ) {
				GenFeature nextGenFeature = (GenFeature) it.next(); 
				String featureName = nextGenFeature.getName();
				String semanticPackageInterfaceName = importManager.getImportedName(nextGenFeature.getGenPackage().getQualifiedPackageInterfaceName());

    stringBuffer.append(TEXT_25);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(accessorName);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(featureName);
    stringBuffer.append(TEXT_28);
    			}
    stringBuffer.append(TEXT_29);
    stringBuffer.append(parserClassName);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(parserClassName);
    stringBuffer.append(TEXT_31);
    
		} else {
			throw new IllegalArgumentException("Unknown label model facet: " + modelFacet);
		}
		if (viewPattern != null && viewPattern.length() != 0) {

    stringBuffer.append(TEXT_32);
    stringBuffer.append(viewPattern);
    stringBuffer.append(TEXT_33);
    
		}
		if (editPattern == null || editPattern.length() == 0) {
			editPattern = viewPattern;
		}
		if (editPattern != null && editPattern.length() != 0) {

    stringBuffer.append(TEXT_34);
    stringBuffer.append(editPattern);
    stringBuffer.append(TEXT_35);
    		}
    stringBuffer.append(TEXT_36);
    
	}
}

    stringBuffer.append(TEXT_37);
    
for (Iterator it1 = labels.keySet().iterator(); it1.hasNext(); ) {
	GenCommonBase genHost = (GenCommonBase) it1.next();
	List labelsList = (List) labels.get(genHost);

    stringBuffer.append(TEXT_38);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_39);
    stringBuffer.append(genHost.getUniqueIdentifier());
    stringBuffer.append(TEXT_40);
    
	if (genHost instanceof GenChildNode && ((GenChildNode) genHost).isListContainerEntry()) {
		GenLabel genLabel = (GenLabel) labelsList.get(0);

    stringBuffer.append(TEXT_41);
    stringBuffer.append(labelMethodNames.get(genLabel));
    stringBuffer.append(TEXT_42);
    
	} else {
		for (Iterator it2 = labelsList.iterator(); it2.hasNext(); ) {
			GenLabel genLabel = (GenLabel) it2.next();

    stringBuffer.append(TEXT_43);
    stringBuffer.append(importManager.getImportedName(genDiagram.getSemanticHintsQualifiedClassName()));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(genHost.getUniqueIdentifier());
    stringBuffer.append(TEXT_45);
    stringBuffer.append(genLabel.getSemanticHintFieldName());
    stringBuffer.append(TEXT_46);
    stringBuffer.append(labelMethodNames.get(genLabel));
    stringBuffer.append(TEXT_47);
    
		}
	}

    stringBuffer.append(TEXT_48);
    }
    stringBuffer.append(TEXT_49);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_50);
    return stringBuffer.toString();
  }
}
