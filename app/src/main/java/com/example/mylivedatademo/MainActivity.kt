package com.example.mylivedatademo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.mylivedatademo.databinding.ActivityMainBinding
import com.example.mylivedatademo.models.AccountModel


class MainActivity : AppCompatActivity() {

    private val myAccount = AccountModel("A1234566","John", 500.00)
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding =  DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myAccount = myAccount
        binding.lifecycleOwner = this

        //binding.lifecycleOwner = Fragment.getViewLifecycleOwner() --> for fragment
        //display()

        //myAccount.balance.observe(this, Observer{newBalance -> binding.tvBalance.text = newBalance.toString() })

        binding.btnDeposit.setOnClickListener(){
            val amount:Double  = binding.tfAmount.text.toString().toDouble()

            myAccount.deposit(amount)

        }

        binding.btnWithdraw.setOnClickListener(){
            val amount:Double  = binding.tfAmount.text.toString().toDouble()
            myAccount.withdraw(amount)

        }
    }

    fun display(){

        binding.tvAccNo.text = myAccount.accNo
        binding.tvName.text = myAccount.owner
        binding.tvBalance.text = myAccount.balance.value.toString()

    }
}