package com.ll.system.system.systemController

import com.ll.TestRunner
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import kotlin.test.Test
import kotlin.test.assertContains

class SystemControllerTest {
    @Test
    @DisplayName("종료")
    fun t1() {
        val result = TestRunner.run("")

        assertThat(result).contains("프로그램을 종료합니다.")
    }
}