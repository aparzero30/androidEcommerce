package ph.stacktrek.novare.eccommercenovare.jimuel.cinco.adapters



import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import ph.stacktrek.novare.eccommercenovare.jimuel.cinco.databinding.ProductItemBinding
import ph.stacktrek.novare.eccommercenovare.jimuel.cinco.model.Product

class ProductAdapter(private val context:Context,
                     private var productList:ArrayList<Product>):
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    fun deleteProduct(position:Int){
        productList.removeAt(position)
        notifyItemRemoved(position)
    }
    fun addProduct(product: Product){
        productList.add(0, product)
        notifyItemInserted(0)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdapter.ViewHolder {
        val productItemBinding = ProductItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(productItemBinding)
    }

    override fun onBindViewHolder(holder: ProductAdapter.ViewHolder, position: Int) {
        holder.bindItems(productList[position])
    }

    override fun getItemCount(): Int = productList.size

    inner class ViewHolder(private val productItemBinding: ProductItemBinding):
        RecyclerView.ViewHolder(productItemBinding.root){

        fun bindItems(product: Product){
            productItemBinding.productName.text = product.name

            productItemBinding.viewProductButton.setOnClickListener {
                Toast.makeText(context, "${product.name}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}