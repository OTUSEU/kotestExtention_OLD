package test

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Test : DescribeSpec({

    describe("test") {

       context("repeat test"){

           it("success test"){
               println("success")
               2 + 2 shouldBe 4
           }

           it("failed test"){
               println("failed")
               2 + 2 shouldBe 8

           }

           it("error test"){
               println("Error")
               throw RuntimeException("Error test")
           }
       }
    }
})