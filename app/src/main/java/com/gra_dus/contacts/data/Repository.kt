package com.gra_dus.contacts.data

import com.gra_dus.contacts.domain.model.Contact
import com.gra_dus.contacts.domain.model.PersonName
import com.gra_dus.contacts.domain.model.Phone
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object Repository : IRepository<Contact> {
    private val items = listOf(
        Contact(
            PersonName("Колян", "Лопаткин"),
            "https://www.nastol.com.ua/download.php?img=201106/1920x1200/nastol.com.ua-4547.jpg",
            listOf(Phone("Мобильный", "+78003293293"), Phone("Стационарный", "(800) 321 2121"))
        ),
        Contact(
            PersonName("Васян", "Табуреткин"),
            "https://www.nastol.com.ua/download.php?img=201303/2560x1600/nastol.com.ua-44575.jpg",
            listOf(Phone("Мобильный", "+78004555740"), Phone("Стационарный", "(800) 915 2113"))
        ),
        Contact(
            PersonName("Тигра", "Васильева"),
            "https://fikiwiki.com/uploads/posts/2022-02/1644814005_2-fikiwiki-com-p-vodopad-krasivie-kartinki-na-rabochii-stol-2.jpg",
            listOf(Phone("Мобильный", "+78001755360"), Phone("Стационарный", "(800) 955 9402"))
        ),
        Contact(
            PersonName("Лёва", "Швец"),
            "https://www.nastol.com.ua/download.php?img=201404/1920x1200/nastol.com.ua-95611.jpg",
            listOf(Phone("Мобильный", "+78001154726"), Phone("Стационарный", "(800) 117 1440"))
        ),
        Contact(
            PersonName("Ольга", "Мак"),
            "https://proprikol.ru/wp-content/uploads/2020/09/kartinki-milyh-zhivotnyh-52.jpg",
            listOf(Phone("Мобильный", "+78001060893"), Phone("Стационарный", "(800) 208 0117"))
        ),
        Contact(
            PersonName("Вован", "Ульянов"),
            "https://www.nastol.com.ua/download.php?img=201411/2560x1440/nastol.com.ua-117318.jpg",
            listOf(Phone("Мобильный", "+78002321917"), Phone("Стационарный", "(800) 256 1922"))
        )
    )

    override suspend fun getList(): List<Contact> {
        withContext(Dispatchers.IO) {
            Thread.sleep(1000L)
        }
        return items
    }

    override suspend fun getItem(id: Int): Contact? {
        return items.find { it.id() == id }
    }
}

interface IRepository<T> {
    suspend fun getList(): List<T>
    suspend fun getItem(id: Int): T?
}