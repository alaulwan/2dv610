package Calculator;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import Calculator.model.AdvancedCalculatorTest;
import Calculator.model.EquationDiscriminantCalculatorTest;
import Calculator.model.EquationTest;
import Calculator.model.StandardCalculatorTest;

@RunWith(Suite.class)
@SuiteClasses({ StandardCalculatorTest.class, AdvancedCalculatorTest.class, EquationTest.class,
				EquationDiscriminantCalculatorTest.class})
public class ProgramTest {

}
