package test;

import java.util.Map;

import junit.framework.TestCase;

import org.eclipse.emf.codegen.merge.java.JControlModel;
import org.eclipse.emf.codegen.merge.java.JMerger;
import org.eclipse.emf.codegen.merge.java.facade.JCompilationUnit;
import org.eclipse.emf.codegen.merge.java.facade.ast.ASTFacadeHelper;
import org.eclipse.jdt.core.JavaCore;

/**
 * @author barnold
 * 
 */
public class JMergeSample extends TestCase {

	/**
	 * @throws Exception
	 */
	public void testJMerge() throws Exception {
		JControlModel jControlModel = new JControlModel();
		
		ASTFacadeHelper astFacadeHelper = new ASTFacadeHelper();
		Map<String,String> jco = astFacadeHelper.getJavaCoreOptions();
		for (String key : jco.keySet()) {
			System.out.println("jco key=" + key + " value=" + jco.get(key));
		}
		String sc = (String) jco.get(JavaCore.COMPILER_SOURCE);
		jco.put(JavaCore.COMPILER_SOURCE, "1.5");
//		jco key=org.eclipse.jdt.core.formatter.tabulation.char value=space
//		jco key=org.eclipse.jdt.core.formatter.tabulation.size value=2
//		jco.put(DefaultCodeFormatterConstants.FORMATTER_TAB_CHAR, "tab");
//		jco.put(DefaultCodeFormatterConstants.FORMATTER_TAB_SIZE, "1");	
		jco.put(JavaCore.FORMATTER_TAB_CHAR, "tab");
		jco.put(JavaCore.FORMATTER_TAB_SIZE, "1");
		jControlModel.initialize(astFacadeHelper, "templates/emf-merge.xml");

		JMerger jMerger = new JMerger(jControlModel);

		JCompilationUnit sourceJCU = jMerger.createCompilationUnitForURI("testcases/input/FqdnUnitEditPart.java"); 

		JCompilationUnit targetJCU = jMerger.createCompilationUnitForURI("testcases/output/FqdnUnitEditPart.java");

		jMerger.setSourceCompilationUnit(sourceJCU);
		
		jMerger.setTargetCompilationUnit(targetJCU);

		jMerger.merge();
		String result = jMerger.getTargetCompilationUnit().getContents();
		System.out.println(result);
	}
}
