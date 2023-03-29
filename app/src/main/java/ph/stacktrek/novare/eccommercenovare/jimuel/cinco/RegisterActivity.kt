package ph.stacktrek.novare.eccommercenovare.jimuel.cinco

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ph.stacktrek.novare.eccommercenovare.jimuel.cinco.databinding.ActivityRegisterBinding


class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_register)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegister.setOnClickListener {
            val intent = Intent()
            intent.putExtra("register_username", binding.registerUsernameText.text.toString())
            intent.putExtra("register_password", binding.registerPasswordText.text.toString())
            setResult(1, intent)
            finish()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val goToMain = Intent(applicationContext,
            LoginActivity::class.java)

        startActivity(goToMain)
        finish()

    }
}