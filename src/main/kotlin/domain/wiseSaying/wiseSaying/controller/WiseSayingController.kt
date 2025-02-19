package com.ll.domain.wiseSaying.wiseSaying.controller

import com.ll.global.rq.Rq
import com.ll.domain.wiseSaying.wiseSaying.service.WiseSayingService

class WiseSayingController {
    var wiseSayingService = WiseSayingService()


    fun actionWrite(rq: Rq) {
        print("명언: ")
        val content = readlnOrNull()!!.trim()
        print("작가: ")
        val author = readlnOrNull()!!.trim()

        val wiseSaying = wiseSayingService.write(content, author)

        println("${wiseSaying.id}번 명언이 등록되었습니다.")
    }

    fun actionList(rq: Rq) {
        if (wiseSayingService.isEmpty()) {
            println("등록된 명언이 없습니다.")
            return
        }

        println(
            "번호 / 작가 / 명언\n" +
                    "----------------------"
        )

//      for (wiseSaying in wiseSayings.reversed()) {
//          println("${wiseSaying.id}  / ${wiseSaying.author} / ${wiseSaying.content}")
//      }
        wiseSayingService.findAll().reversed().forEach {
            println("${it.id} / ${it.author} / ${it.content}")
        }
    }

    fun actionDelete(rq: Rq) {
        val id = rq.getParamValueAsInt("id", 0)

        /*val removed = wiseSayings.removeIf {it.id == id}
        if (removed) println("${id}번 명언이 삭제되었습니다.")
        else (println("${id}번 명언은 존재하지 않습니다."))*/

        val wiseSaying = wiseSayingService.findById(id)
        // firstOrNull: 있으면 리턴하고, 없으면 하고 없으면 마셈

        if (wiseSaying == null) {
            println("${id}번 명언은 존재하지 않습니다.")
            return
        }

        wiseSayingService.delete(wiseSaying)
        println("${id}번 명언이 삭제되었습니다.")
    }

    fun actionModify(re: Rq) {
        val id = re.getParamValueAsInt("id", 0)

        val wiseSaying = wiseSayingService.findById(id)

        if (wiseSaying == null) {
            println("${id}번 명언은 존재하지 않습니다.")
            return
        }

        print("명언(기존) ${wiseSaying.content}")
        print("명언: ")
        val content = readlnOrNull()!!.trim()

        print("작가(기존) ${wiseSaying.author}")
        print("작가: ")
        val author = readlnOrNull()!!.trim()

        wiseSayingService.modify(wiseSaying, content, author)

        println("${id}번 명언이 수정되었습니다.")
    }
}