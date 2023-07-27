package es.sarman.hackaprende.fakebot

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import es.sarman.hackaprende.fakebot.databinding.ActivityMainBinding
import es.sarman.hackaprende.fakebot.implementations.MessagesRVAdapter
import es.sarman.hackaprende.fakebot.models.Message
import es.sarman.hackaprende.fakebot.models.ResponsesList
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val msgList = ArrayList<Message>()
        msgList.add(Message(message = "Primer mensaje", from = "user"))
        msgList.add(Message(message = ResponsesList().getRandomResponse(), from = "bot"))

        val adapter = MessagesRVAdapter(msgList)
        binding.msgList.adapter = adapter
        binding.msgList.layoutManager = LinearLayoutManager(this)

        if (msgList.isEmpty()) {
            binding.msgList.visibility = View.GONE
            binding.noMsgText.visibility = View.VISIBLE
        }

        binding.sendMsgBtn.setOnClickListener {
            if (binding.userMsgInput.text.isEmpty()) {
                Toast.makeText(this, "El mensaje esta vacio", Toast.LENGTH_SHORT)
            } else {
                adapter.addMessage(Message(message = binding.userMsgInput.text.toString(), from = "user"))
                binding.userMsgInput.text.clear()
                Handler(Looper.myLooper()!!).postDelayed(kotlinx.coroutines.Runnable {
                    adapter.addMessage(Message(message = ResponsesList().getRandomResponse(), from = "bot"))
                }, Random.nextLong(TimeUnit.SECONDS.toMillis(1), TimeUnit.SECONDS.toMillis(3)))
            }
        }
    }
}