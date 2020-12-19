package org.sairaa.dqn
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.dqn.R
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject
import org.sairaa.dqn.viewModels.SampleViewModel

class MainActivity : AppCompatActivity() {

    val viewModel by inject<MainViewModel>()

    val student2 by inject<Student>()

    private val sampleViewModel by inject<SampleViewModel>()

//    private val sampleViewModel by viewModel<SampleViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val student = get<Student>()
        student.activity()

        student2.activity()

//        val viewModel = get<MainViewModel>()
//        viewModel.performAction()

        doSomething()

    }

    private fun doSomething() {
        viewModel.performAction()
        sampleViewModel.getSampleData()
        sampleViewModel.sampleData.observe(this, Observer {data->
            Log.d("Test",""+data.get(0).description)
        })
    }


}