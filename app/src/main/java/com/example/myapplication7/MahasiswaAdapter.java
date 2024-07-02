package com.example.myapplication7;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MahasiswaAdapter extends RecyclerView.Adapter<MahasiswaAdapter.MahasiswViewHolder> {
    private List<Mahasiswa> MahasiswaList;
    private Context context;
    private MainActivity mainActivity; // Referensi ke MainActivity

    // Konstruktor UserAdapter yang menerima List<User> dan Context
    public MahasiswaAdapter(List<Mahasiswa> MahasiswaList, Context context) {
        this.MahasiswaList = MahasiswaList;
        this.context = context;

        // Check if context is an instance of MainActivity and set mainActivity
        if (context instanceof MainActivity) {
            this.mainActivity = (MainActivity) context;
        }
    }

    @NonNull
    @Override
    public MahasiswaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_Mahasiswa, parent, false);
        return new MahasiswaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MahasiswaViewHolder holder, int position) {
        final Mahasiswa Mahasiswa = MahasiswaList.get(position);
        holder.name.setText(Mahasiswa.getName());
        holder.email.setText(Mahasiswa.getEmail());
        holder.nim.setText(Mahasiswa.getNim());
        holder.alamat.setText(Mahasiswa.getAlamat());

        // Mengatur OnClickListener pada itemView untuk menangani tap pada item
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mainActivity != null) {
                    mainActivity.showUpdateDialog(Mahasiswa);
                }
            }
        });

        // Mengatur OnClickListener pada tombol delete untuk menangani tap pada tombol delete
        holder.buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDeleteConfirmationDialog(Mahasiswa.getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return MahasiswaList.size();
    }

    // Metode untuk menampilkan dialog konfirmasi penghapusan
    private void showDeleteConfirmationDialog(final int MahasiswaId) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Delete Mahasiswa");
        builder.setMessage("Are you sure you want to delete this Mahasiswa?");

        builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                deleteMahasiswa(MahasiswaId);
            }
        });

        builder.setNegativeButton("Cancel", null);

        builder.show();
    }

    // Metode untuk menghapus pengguna dari daftar dan server
    private void deleteMahasiswa(int MahasiswaId) {
        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<Void> call = apiService.deleteMahasiswa(MahasiswaId);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    for (int i = 0; i < MahasiswaList.size(); i++) {
                        if (MahasiswaList.get(i).getId() == MahasiswaId) {
                            MahasiswaList.remove(i);
                            notifyItemRemoved(i);
                            break;
                        }}
                    Toast.makeText(context, "Mahasiswa deleted successfully", Toast.LENGTH_SHORT).show();
                    // Refresh Mahasiswa list after deletion
                    mainActivity.refreshData();
                } else {
                    Toast.makeText(context, "Failed to delete Mahasiswa: " + response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(context, "Failed to delete Mahasiswa: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    // ViewHolder untuk MahasiswaAdapter
    public class MahasiswaViewHolder extends RecyclerView.ViewHolder {
        public TextView name, email, nim, alamat;
        public Button buttonDelete;

        public MahasiswaViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textViewName);
            email = itemView.findViewById(R.id.textViewEmail);
            nim = itemView.findViewById(R.id.textViewNim);
            alamat = itemView.findViewById(R.id.textViewAlamat);
            buttonDelete = itemView.findViewById(R.id.buttonDelete);
        }
    }

    // Metode untuk mengatur MainActivity yang terkait
    public void setMainActivity(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

}
