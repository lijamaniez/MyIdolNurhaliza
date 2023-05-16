package com.elsa.myapplication.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.elsa.myapplication.DetailActivity
import com.elsa.myapplication.Idol
import com.elsa.myapplication.IdolAdapter
import com.elsa.myapplication.R


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    private lateinit var adapter: IdolAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var IdolArrayList: ArrayList<Idol>

    lateinit var image: Array<Int>
    lateinit var name: Array<String>
    lateinit var desc: Array<String>

    companion object{
        val INTENT_PARCELABLE = "OBJECT_INTENT"

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rv_idol)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = context?.let {
            IdolAdapter(it, IdolArrayList){
                val intent = Intent(context, DetailActivity::class.java)
                intent.putExtra(INTENT_PARCELABLE, it)
                startActivity(intent)
            }
        }

    }

    fun dataInitialize(){
        IdolArrayList = arrayListOf<Idol>()

        image = arrayOf(
            R.drawable.sp1,
            R.drawable.sp2,
            R.drawable.sp3,
            R.drawable.sp4,
            R.drawable.sp5,
            R.drawable.sp6,
            R.drawable.sp7,
            R.drawable.sp8,
            R.drawable.sp9,
            R.drawable.sp10,
        )

        name = arrayOf(
            "Idol1",
            "Idol2",
            "Idol3",
            "Idol4",
            "Idol5",
            "Idol6",
            "Idol7",
            "Idol8",
            "Idol9",
            "Idol10",
        )

        desc = arrayOf(
            "This is my Idol",
            "This is my Idol",
            "This is my Idol",
            "This is my Idol",
            "This is my Idol",
            "This is my Idol",
            "This is my Idol",
            "This is my Idol",
            "This is my Idol",
            "This is my Idol",

            )

        for (i in image.indices){
            val idol = Idol(image[i], name[i], desc[i])
            IdolArrayList.add(idol)
        }
    }
}