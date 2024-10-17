package com.fps69.recycler_view

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class MyAdapter(private var newsarraylist : ArrayList<UserDataClass>):
    RecyclerView.Adapter<MyAdapter.myViewHolder>()/*>>> Yha hamlog MyAdapter class ko extend kr rhe hai RecyclerView.Adapter is class se
                                                    >>> Or MyAdapter ka eak important subcass hota hai myViewHolder
                                                    >>> myViewHolder class ko niche create kr rhe hai
                                                   */
{
        private lateinit var myListner : OnItemclickListner

        interface OnItemclickListner{
            fun OnItemClicking(postion : Int)
        }

    fun SetOnItemClickListener(Listner:OnItemclickListner){

        myListner = Listner

    }




    // Ye MyAdapter ke three important method/Function hai
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.myViewHolder/*>>> onCreateViewHolder: This function is responsible for creating ViewHolder objects.
                                                                                                   When RecyclerView needs a new ViewHolder to represent an item, it calls
                                                                                                   this method.
                                                                                               >>> In this function, you inflate the layout for a single item view using LayoutInflater,
                                                                                                   create a ViewHolder instance with this inflated view, and return it. This method is
                                                                                                   called when RecyclerView needs a new ViewHolder of the given type to represent an item.*/
    {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.each_item,parent,false)
        return myViewHolder(view, myListner)
        /*
        >>> val view = LayoutInflater.from(parent.context): This line creates a LayoutInflater object using
            LayoutInflater.from() function. It is used to inflate XML layouts.
        >>> .inflate(R.layout.each_item, parent, false): This line inflates the XML layout.
            Here, 'each_item' is the layout for our item. 'parent' is the ViewGroup that will
            be the parent of the inflated view, and 'false' indicates that the inflated view should
            not be attached to the parent ViewGroup.
       >>> return ViewHolder(view): Finally, we create a new ViewHolder, passing the inflated view
           to it. This ViewHolder is responsible for holding references to the views of the
           RecyclerView item.

       >>> The inflate() method in Android is used to inflate a layout resource file into its
           corresponding View objects. Let's break down the parameters parent and false in the inflate()
           method:
           >>> parent: This parameter specifies the ViewGroup to which the inflated view will be
               attached if it's not already specified in the layout file itself. The ViewGroup is
               needed for correctly setting layout parameters when inflating the view. In the context
               of a RecyclerView, parent refers to the ViewGroup that will contain the item views,
               typically the RecyclerView itself.
           >>> false: This parameter indicates whether the inflated view should be attached to the
               parent ViewGroup during inflation. When false is passed, it means the inflated view
               will not be automatically attached to the parent ViewGroup. In the case of a RecyclerView,
               you usually want to pass false here because RecyclerView itself will handle adding and
               removing item views dynamically as needed. If you pass true, the inflated view will
               be added to the parent ViewGroup immediately, which is not what you typically want
               in the context of RecyclerView usage.*/
    }



    override fun onBindViewHolder(holder: MyAdapter.myViewHolder, position: Int)/*>>> onBindViewHolder: This function is responsible for binding data to ViewHolder objects.
                                                                                      When a ViewHolder is bound to a position, this method is called to populate the data
                                                                                      into the views inside the ViewHolder. Here, you retrieve the item from the dataset
                                                                                      based on the ViewHolder's position, and then use that data to set the appropriate
                                                                                      values in the ViewHolder's views.*/
    {
        val cureentItem = newsarraylist[position]
        holder.hTitle.text=cureentItem.newsHeading
        holder.hImage.setImageResource(cureentItem.newsImage)
    }

    override fun getItemCount(): Int /*>>> It returns information about the number of items in newsarraylist
                                      >>>  getItemCount: This function returns the total number of items in
                                           the dataset. RecyclerView uses this method to determine how many
                                           items are in the data set. This number influences the number of
                                           items that will be shown on the screen.*/
    {
        return newsarraylist.size
    }



    // Creating myViewHolder class
    class myViewHolder(itemView : View, listener:OnItemclickListner) : RecyclerView.ViewHolder(itemView)/*>>> Iss myViewHolder class ko extend kr rhe hai RecyclerView.ViewHolder class se
                                                                             >>> Jo eak parameter leta hai View type ka (Item ka view )
                                                                             >>> Iss liye itemView ko pass kr rhe hai */
    {
        val hTitle = itemView.findViewById<TextView>(R.id.headingTitle1)
        val hImage = itemView.findViewById<ShapeableImageView>(R.id.headingImage1)

        /*
        WORKING OF VIEW HOLDER CLASS

        >>> In summary, this myViewHolder class is responsible for encapsulating view references
            for specific views (a TextView and a ShapeableImageView) within the layout of a single
            item in the RecyclerView. These view references are initialized when an instance of
            myViewHolder is created, allowing for efficient access and manipulation of these
            views when binding data to the item in the RecyclerView. This ViewHolder pattern is
            commonly used to optimize performance and organize the code when working with
            RecyclerView adapters in Android development.
         */


        /*

        USE OF VIEW HOLDER Class
        >>> The ViewHolder class in RecyclerView is a crucial part of the pattern that RecyclerView
            uses to efficiently manage and display large lists of data. Its primary purpose is to
            hold references to the views for a single item in the RecyclerView. Let's delve deeper
            into its usage and significance:

            >>> Improving Performance: The primary motivation behind the ViewHolder pattern is to
                improve the performance of RecyclerView by minimizing the number of calls to
                findViewById(). In traditional adapters like ArrayAdapter or BaseAdapter,
                this method would be called for each item in the list, leading to performance
                bottlenecks, especially for large datasets. The ViewHolder pattern mitigates this
                issue by caching the references to views within each item.

            >>> Caching Views: In a RecyclerView, the onCreateViewHolder() method is called when
                RecyclerView needs a new ViewHolder instance. You inflate the layout for a single
                item and pass it to a new instance of your ViewHolder class. In the ViewHolder
                constructor, you use findViewById() to find and store references to the views
                that you want to manipulate, such as TextViews, ImageViews, etc.

            >>> Binding Data: Once a ViewHolder is created or recycled, the onBindViewHolder()
                method is called. Here, you retrieve the data for the corresponding item from
                your dataset and update the views held by the ViewHolder with this data.
                Since you've already obtained references to the views during ViewHolder creation,
                you don't need to call findViewById() again, which improves performance

            >>> Encapsulation: By encapsulating view references within the ViewHolder, you ensure
                that each ViewHolder instance is responsible for managing the views of its associated
                item. This encapsulation enhances code organization and readability, making it
                easier to understand and maintain your RecyclerView adapter.

            >>> ViewHolder Reuse: RecyclerView recycles ViewHolder instances as you scroll through
                the list. When an item scrolls off the screen, its ViewHolder is recycled and reused
                for new items that come into view. This recycling mechanism minimizes memory
                overhead and contributes to smoother scrolling performance.

      >>>> In summary, the ViewHolder pattern in RecyclerView is essential for optimizing performance
      and memory usage when dealing with large datasets. By caching view references and encapsulating
      view management logic, it helps ensure smooth and efficient scrolling behavior in your
      RecyclerView-based UIs*/

        init {
            itemView.setOnClickListener {

                listener.OnItemClicking(adapterPosition)  // adapterPosition :- jha pe click krege wha ka position mil jayega

            }
        }

    }
}