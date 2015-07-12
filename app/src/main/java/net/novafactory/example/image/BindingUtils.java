package net.novafactory.example.image;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class BindingUtils {

   @BindingAdapter({"bind:imageUrl", "bind:error"})
   public static void loadImage(ImageView view, String url, Drawable error) {
      Picasso.with(view.getContext()).load(url).error(error).into(view);
   }
}