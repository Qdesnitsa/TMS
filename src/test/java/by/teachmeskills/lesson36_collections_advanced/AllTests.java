package by.teachmeskills.lesson36_collections_advanced;

import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Execution(ExecutionMode.CONCURRENT)
@SelectPackages({"by.teachmeskills.lesson36_collections_advanced.list"})
@Suite
@IncludeTags({"utils"})
public class AllTests {
}
