package by.tms.calculator;

import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Execution(ExecutionMode.CONCURRENT)
@SelectPackages({"by.tms.calculator.calculation",
                "by.tms.calculator.util"})
@Suite
@IncludeTags({"calculator","utils"})
public class AllTests {
}

