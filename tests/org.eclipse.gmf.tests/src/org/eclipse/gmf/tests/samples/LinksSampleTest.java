package org.eclipse.gmf.tests.samples;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.gmf.codegen.gmfgen.GMFGenFactory;
import org.eclipse.gmf.codegen.gmfgen.GenCustomGeneratorExtension;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.gmfgen.GenTemplateInvocation;
import org.eclipse.gmf.tests.setup.RuntimeBasedGeneratorConfiguration;


public class LinksSampleTest extends BaseSampleTest {

	public static final String GIT_GMFGEN_PATH = "platform:/plugin/org.eclipse.gmf.tooling.examples.links/model/links.gmfgen";
	
	public LinksSampleTest(String name) {
		this(name, new RuntimeBasedGeneratorConfiguration());
	}
	
	public LinksSampleTest(String name, RuntimeBasedGeneratorConfiguration genConfig) {
		super(name, genConfig);
	}
	
	@Override
	protected String getRelativeGMFGENPath() {
		return GIT_GMFGEN_PATH;
	}
	
	public void testAspects() throws Exception {
		GenEditorGenerator editorGen = prepareCustomEditorGen("aspects", true);
		genAndCompile(editorGen, getGenerationConfiguration());
		IProject aspectsProject = ResourcesPlugin.getWorkspace().getRoot().getProject(editorGen.getPluginDirectory().split("/")[1]);
		assertTrue(aspectsProject.exists());
		IFile file = aspectsProject.getFile(new Path("src/org/eclipse/gmf/tooling/examples/links/diagram/aspects/edit/parts/ChildNodeBEditPart.java"));
		assertTrue(file.exists());
		BufferedReader classToTest = new BufferedReader(new InputStreamReader(file.getContents(), file.getCharset()));
		boolean foundCommentExtendedCommon = false;
		boolean foundCommentBaseCommon = false;
		String line;
		while ((line = classToTest.readLine()) != null) {
			if (line.trim().startsWith("/** comment generated by aspects.CommonExtended */")) {
				foundCommentExtendedCommon = true;
			}
			if (line.trim().startsWith("* @generated")) {
				foundCommentBaseCommon = true;
			}
		}
		assertTrue("Aspects code was not invoked.", foundCommentExtendedCommon);
		assertFalse("Aspects code was not replase base code.", foundCommentBaseCommon);
	}
	
	protected GenEditorGenerator prepareCustomEditorGen(String suffix, boolean useDynamicTemplates) throws Exception {
		GenEditorGenerator editorGen = loadGMFGENModel(getRelativeGMFGENPath());
		editorGen.setPackageNamePrefix(createPackageNamePrefix(editorGen, suffix));
		editorGen.setPluginDirectory(createPluginDirectory(editorGen, suffix));
		editorGen.getPlugin().setID(editorGen.getPlugin().getID() + "." + suffix);
		editorGen.setTemplateDirectory("platform:/plugin/org.eclipse.gmf.tooling.examples.links/xtend/");
		editorGen.setDynamicTemplates(useDynamicTemplates);
		return editorGen;
	}
	
	protected GenCustomGeneratorExtension createCustomExtension(GenEditorGenerator self) {
		GenCustomGeneratorExtension result = GMFGenFactory.eINSTANCE.createGenCustomGeneratorExtension();
		result.setRootInput(self);
		GenTemplateInvocation t = GMFGenFactory.eINSTANCE.createGenTemplateInvocation();
		t.setOclExpression("self");
		t.setTemplateFqn("custom::CustomTemplate::CustomTemplate");
		result.getInvocations().add(t);
		return result;
	}
	
	private String createPackageNamePrefix(GenEditorGenerator editorGen, String suffix) {
		return editorGen.getPackageNamePrefix() + "." +suffix;
	}
	
	private String createPluginDirectory(GenEditorGenerator editorGen, String suffix) {
		String pluginDirectory = editorGen.getPluginDirectory();
		if (pluginDirectory.startsWith("/")) {
			pluginDirectory = pluginDirectory.substring(1);
		}
		String[] pluginDirectoryParts = pluginDirectory.split("/");
		StringBuilder result = new StringBuilder("/").append(pluginDirectoryParts[0]);
		result.append(".").append(suffix).append("/");
		for (int i = 1; i < pluginDirectoryParts.length; i++) {
			result.append(pluginDirectoryParts[i]).append("/");
		}
		return result.toString();
	}
}
