package com.ll.global.bean

import com.ll.domain.system.system.controller.SystemController
import com.ll.domain.wiseSaying.wiseSaying.controller.WiseSayingController
import com.ll.domain.wiseSaying.wiseSaying.repository.WiseSayingMemoryRepository
import com.ll.domain.wiseSaying.wiseSaying.repository.WiseSayingRepository
import com.ll.domain.wiseSaying.wiseSaying.service.WiseSayingService
import com.ll.domain.wiseSaying.wiseSaying.repository.WiseSayingFileRepository as WiseSayingFileRepository1

object SingletonScope {
    val wiseSayingController by lazy { WiseSayingController() }
    val wiseSayingService by lazy { WiseSayingService() }
    val wiseSayingRepository: WiseSayingRepository by lazy { WiseSayingMemoryRepository() }
    val wiseSayingFileRepository by lazy { WiseSayingFileRepository1() }
    val systemController by lazy { SystemController() }
}