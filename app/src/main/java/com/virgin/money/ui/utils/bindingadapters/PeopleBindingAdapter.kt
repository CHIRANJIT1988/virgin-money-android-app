package com.virgin.money.ui.utils.bindingadapters

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.virgin.money.data.models.People
import com.virgin.money.ui.utils.ImageUtils

object PeopleBindingAdapter {

    @BindingAdapter("bindPeopleName")
    @JvmStatic
    fun TextView.bindPeopleName(people: People) {
        text = people.firstName.plus(" ").plus(people.lastName)
    }

    @BindingAdapter("bindPeopleEmail")
    @JvmStatic
    fun TextView.bindPeopleEmail(people: People) {
        text = people.email
    }

    @BindingAdapter("bindPeopleJobTitle")
    @JvmStatic
    fun TextView.bindPeopleJobTitle(people: People) {
        text = people.jobTitle
    }

    @BindingAdapter("bindPeopleAvatar")
    @JvmStatic
    fun ImageView.bindPeopleAvatar(people: People) {
        ImageUtils.loadFromUrl(people.avatar, this)
    }
}
