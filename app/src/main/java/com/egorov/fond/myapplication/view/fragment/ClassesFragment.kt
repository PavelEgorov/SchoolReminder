package com.egorov.fond.myapplication.view.fragment

import android.os.Bundle
import android.view.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.egorov.fond.myapplication.R
import com.egorov.fond.myapplication.di.NAME_CLASSES
import com.egorov.fond.myapplication.entity.Class
import com.egorov.fond.myapplication.entity.ClassesView
import com.egorov.fond.myapplication.view.adapter.AdapterClasses
import com.egorov.fond.myapplication.view.viewmodel.BaseViewModel
import com.egorov.fond.myapplication.view.viewmodel.IView
import kotlinx.android.synthetic.main.fragment_classes.*
import org.koin.android.ext.android.inject
import org.koin.core.qualifier.named


class ClassesFragment : IView<ClassesView>() {
    private val viewModel: BaseViewModel<ClassesView> by inject(named(NAME_CLASSES))

    private var adapter: AdapterClasses? = null

    companion object{
        fun newInstance() = ClassesFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_classes, container, false)
    }

    override fun onStart() {
        super.onStart()
        viewModel.update(this)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear();
        inflater.inflate(R.menu.classes_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }

    override fun render(responce: ClassesView) {
        renderRecycleView(responce.listClass.toMutableList())
    }

    private fun renderRecycleView(classes: MutableList<Class>) {
        if (adapter == null) {
            initRecyclerView(classes)
        } else
            adapter!!.update(classes)
    }

    private fun initRecyclerView(
            classes: MutableList<Class>,
    ) {
        adapter = AdapterClasses(
                classes
        )

        rv_classes.layoutManager = LinearLayoutManager(context)
        rv_classes.adapter = adapter
        rv_classes.setHasFixedSize(true)
    }
}