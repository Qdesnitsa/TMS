package by.tms.lesson22_23_34_servlet_junit.calculator;

import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Execution(ExecutionMode.CONCURRENT)
@SelectPackages({"by.teachmeskills.lesson22_23_34_servlet_junit.calculator.calculation",
                "by.teachmeskills.lesson22_23_34_servlet_junit.calculator.util"})
@Suite
@IncludeTags({"calculator","utils"})
public class AllTests {
}