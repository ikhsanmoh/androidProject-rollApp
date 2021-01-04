package project.roll.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import project.roll.PhotographerProfileActivity;
import project.roll.R;
import project.roll.model.Photographer;

import static project.roll.PhotographerProfileActivity.PHOTOGRAPHER_ID_KEY;

public class PhotographersRecViewAdapter extends RecyclerView.Adapter<PhotographersRecViewAdapter.ViewHolder> {

  private ArrayList<Photographer> photographers = new ArrayList<>();
  private Context context;

  public PhotographersRecViewAdapter(Context context) {
    this.context = context;
  }

  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.photographer_list_item, parent, false);
    ViewHolder holder = new ViewHolder(view);
    return holder;
  }

  @Override
  public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
    holder.txtName.setText(photographers.get(position).getName());
    holder.parent.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
//        Toast.makeText(context, photographers.get(position).getName() + " Selected", Toast.LENGTH_SHORT).show();
        Intent myIntent = new Intent(context, PhotographerProfileActivity.class);
        myIntent.putExtra(PHOTOGRAPHER_ID_KEY, photographers.get(position).getId());
        context.startActivity(myIntent);
      }
    });
    Glide.with(context)
            .asBitmap()
            .load(photographers.get(position).getImgUrl())
            .into(holder.img);
  }

  @Override
  public int getItemCount() {
    return photographers.size();
  }

  public void setPhotographers(ArrayList<Photographer> photographers) {
    this.photographers = photographers;
    notifyDataSetChanged();
  }

  public class ViewHolder extends RecyclerView.ViewHolder{

    private TextView txtName;
    private CardView parent;
    private ImageView img;

    public ViewHolder(@NonNull View itemView) {
      super(itemView);
      parent = itemView.findViewById(R.id.parent);
      txtName = itemView.findViewById(R.id.txtName);
      img = itemView.findViewById(R.id.image);
    }
  }
}
