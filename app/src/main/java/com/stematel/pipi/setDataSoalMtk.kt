package com.stematel.pipi

object setDataSoalMtk {

    const val name:String="name"
    const val score:String="score"

    fun getQuestion():ArrayList<QuestionData>{
        val que:ArrayList<QuestionData> = arrayListOf()

        val question1 = QuestionData(
            1,
            "Hasil panen kakek selama 5 bulan dalam ton adalah 10, 6, 7, 9, 8. Rata-rata hasil panen kakek tiap bulan adalah .... ton.",

            "7",
            "8",
            "9",
            "10",
            2
        )
        val question2 = QuestionData(
            2,
            "Hasil ulangan matematika 21 anak kelas VI adalah: 7, 8, 9, 8, 7, 8, 10, 9, 5, 7, 9, 9, 8, 7, 10, 8, 9, 6, 8,7, dan 5. Apabila data tersebut diurutkan dari terkecil hingga terbesar, maka nilai tengah dari data tersebut adalah....",

            "6",
            "7",
            "8",
            "9",
            3
        )
        val question3 = QuestionData(
            3,
            "Rata-rata nilai Matematika Yunus selama 4 kali ulangan adalah 75. Setelah ulangan yang ke-lima, rata-rata nilai Yunus 80. Nilai ke-lima yang didapat Yunus adalah ....",

            "80",
            "85",
            "90",
            "100",
            4
        )
        val question4 = QuestionData(
            4,
            "Nilai rata-rata Matematika  5 orang siswa adalah 90. Jika ditambah dengan nilai Amel, nilai rata-rata menjadi 85. Nilai Amel adalah ....",

            "60",
            "70",
            "80",
            "90",
            1
        )
        val question5 = QuestionData(
            5,
            "Nilai ulangan Ayu adalah 7, 8, 7, 6, dan 8. Jika Ayu ingin mendapat nilai rata-rata 7,5, maka nilai ulangan keenam Ayu harus ....",

            "7",
            "8",
            "8,5",
            "9",
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