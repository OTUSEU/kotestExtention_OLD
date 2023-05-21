package test

import io.kotest.core.extensions.TestCaseExtension
import io.kotest.core.spec.AutoScan
import io.kotest.core.test.TestCase
import io.kotest.core.test.TestResult

@AutoScan
class RepeatOnFailureExtension : TestCaseExtension {
    private val count = 5
    override suspend fun intercept(testCase: TestCase, execute: suspend (TestCase) -> TestResult): TestResult {

        lateinit var result: TestResult
        repeat(count) {
            result = execute.invoke(testCase)
            if (result.isErrorOrFailure.not()) return result
        }
        return result
    }
}
