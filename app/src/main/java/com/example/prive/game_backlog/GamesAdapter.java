package com.example.prive.game_backlog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class GamesAdapter extends RecyclerView.Adapter<GamesAdapter.GamesViewHolder> {

    private List<Game> gameList;
    private Context context;

    public GamesAdapter(List<Game> gameList, Context context) {
        this.gameList = gameList;
        this.context = context;
    }

    @NonNull
    @Override
    public GamesAdapter.GamesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cardview, parent, false);

        // Return a new holder instance

        GamesAdapter.GamesViewHolder gamesViewHolder = new GamesAdapter.GamesViewHolder(view);
        return gamesViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull GamesViewHolder holder, int position) {
        Game games = gameList.get(position);
        holder.title.setText(games.getName());
        holder.platform.setText(games.getPlatform());
        holder.status.setText(games.getStatus());
        holder.date.setText(games.getDate());
    }

    @Override
    public int getItemCount() {
        return gameList.size();
    }

    public class GamesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView title;
        public TextView platform;
        public TextView status;
        public TextView date;

        int clickedPosition = getAdapterPosition();

        GamesViewHolder(View gameView) {

            super(gameView);

            title = (TextView) gameView.findViewById(R.id.Name);
            platform = (TextView) gameView.findViewById(R.id.Platform);
            status = (TextView) gameView.findViewById(R.id.Status);
            date = (TextView) gameView.findViewById(R.id.Date);

            gameView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
        }
    }
}

