package com.stematel.pipi

object setDataSoalIpa {

    const val name:String="name"
    const val score:String="score"

    fun getQuestion():ArrayList<QuestionData>{
        val que:ArrayList<QuestionData> = arrayListOf()

        val question1 = QuestionData(
            1,
            "Berikut ini yang bukan termasuk macam-macam magnet adalah ...",

            "ladam",
            "jarum",
            "silinder",
            "isolator",
            4
        )
        val question2 = QuestionData(
            2,
            "Setiap magnet mempunyai dua bagian yang sangat kuat gaya magnetnya, bagian tersebut dinamakan ...",

            "pusat magnet",
            "kutub magnet",
            "arus magnet",
            "magnetik",
            2
        )
        val question3 = QuestionData(
            3,
            "Jika magnet pada kutub yang sama didekatkan maka akan ...",

            "menempel",
            "tolak-menolak",
            "tidak terjadi apa-apa",
            "terbakar",
            2
        )
        val question4 = QuestionData(
            4,
            "Magnet jarum digunakan pada benda ...",

            "kompas",
            "jam",
            "mesin jahit",
            "termometer",
            1
        )

        val question5 = QuestionData(
            5,
            "Contoh benda yang dapat di tarik magnet adalah ...",

            "sandal, sepatu, dan peniti",
            "peniti, pisau, dan gabus",
            "pisau, gergaji, dan kaca",
            "peniti, gunting, dan paku",
            4
        )

        que.add(question1)
        que.add(question2)
        que.add(question3)
        que.add(question4)
        que.add(question5)
        return que
    }
}