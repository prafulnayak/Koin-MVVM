package org.sairaa.rightly

import androidx.lifecycle.ViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val appModule: Module = module {
    single{ SchoolCourse() }

    factory { Friend() }

    factory { Student(get(), get()) }

}

val viewModelModule:Module = module {
    viewModel { MainViewModel(get(), get()) }
}


class Student(private val schoolCourse: SchoolCourse, private val friend: Friend){

    fun activity(){
        schoolCourse.study()
        friend.hangOut()
    }
}

class SchoolCourse{
    fun study(){
        println("Studying")
    }
}

class Friend{
    fun hangOut(){
        println("Hangout")
    }
}

class MainViewModel(val schoolCourse: SchoolCourse, val friend: Friend):ViewModel(){
    fun performAction(){
        schoolCourse.study()
        friend.hangOut()
        println("View Model")
    }
}