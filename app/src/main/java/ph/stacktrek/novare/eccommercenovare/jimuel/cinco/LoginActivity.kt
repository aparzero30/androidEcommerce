package ph.stacktrek.novare.eccommercenovare.jimuel.cinco

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.snackbar.Snackbar
import ph.stacktrek.novare.eccommercenovare.jimuel.cinco.databinding.ActivityLoginBinding
import ph.stacktrek.novare.eccommercenovare.jimuel.cinco.utility.PreferenceUtility

class LoginActivity : AppCompatActivity() {

    private lateinit var binding:ActivityLoginBinding

    private val launchRegister = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        val data = result.data

        val username = data?.getStringExtra("register_username")
        val password = data?.getStringExtra("register_password")

        binding.usernametext.setText(username)
        binding.passwordtext.setText(password)

        Snackbar.make(binding.root,
            "Registered ${data!!.getStringExtra("register_username")}",
            Snackbar.LENGTH_LONG).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_login)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.registerButton.setOnClickListener {
//            val goToRegister = Intent(
//                applicationContext,
//                RegisterActivity::class.java
//            )
//
//            startActivity(goToRegister)
//            launchRegister.launch(goToRegister)

            val goToRegister = Intent(
                applicationContext,
                RegisterActivity::class.java
            )

            launchRegister.launch(goToRegister)


        }

        binding.loginButton.setOnClickListener {

            var username = binding.usernametext.text.toString()
            var password = binding.passwordtext.text.toString()

            if(username == "admin" && password == "admin") {

                PreferenceUtility(applicationContext).apply {
                    saveStringPreferences("username", binding.usernametext.text.toString())
                    saveStringPreferences("password", binding.passwordtext.text.toString())
                }



                val goToMain = Intent(
                    applicationContext,
                    MainActivity::class.java
                )
                goToMain.putExtra("username", username)

                val bundle = Bundle()
                bundle.putString("bundle_username", username)
                goToMain.putExtras(bundle)


                startActivity(goToMain)
                finish()
            }else{
                Snackbar.make(binding.root,
                    "Please provide admin/admin",
                    Snackbar.LENGTH_SHORT).show()
            }



        }

        PreferenceUtility(applicationContext).apply {
            binding.usernametext.setText(getStringPreferences("username" ))
            binding.passwordtext.setText(getStringPreferences("password" ))
        }


    }
//    override fun onBackPressed() {
//        super.onBackPressed()
//        val goToMain = Intent(applicationContext,
//            LoginActivity::class.java)
//
//        startActivity(goToMain)
//        finish()
//
//    }

}