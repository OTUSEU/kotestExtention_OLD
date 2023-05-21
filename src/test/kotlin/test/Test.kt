package test

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.delay

class Test : DescribeSpec({

    describe("test") {

       context("repeat test"){

           it("success test"){
               delay(1000L)
               println("success")
               2 + 2 shouldBe 4
           }

           it("failed test"){
               delay(1000L)
               println("failed")
               2 + 2 shouldBe 8

           }

           it("error test"){
               delay(1000L)
               println("Error")
               throw RuntimeException("Error test")
           }
       }
    }
})