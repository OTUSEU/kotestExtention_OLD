package test

import io.kotest.core.extensions.TestCaseExtension
import io.kotest.core.spec.AutoScan
import io.kotest.core.test.TestCase
import io.kotest.core.test.TestResult

@AutoScan
class RepeatOnFailureExtension : TestCaseExtension {


    override suspend fun intercept(testCase: TestCase, execute: suspend (TestCase) -> TestResult): TestResult {
        var count = 5
        lateinit var result: TestResult
        while (count > 0) {
            result = execute.invoke(testCase)
            if (result.isErrorOrFailure) {
                count--
            }
            else break
        }

        return result
    }
}
