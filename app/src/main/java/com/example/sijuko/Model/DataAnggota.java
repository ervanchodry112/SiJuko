package com.example.sijuko.Model;

import com.google.gson.annotations.SerializedName;

public class DataAnggota{

	@SerializedName("nama_lengkap")
	private String namaLengkap;

	@SerializedName("npm")
	private String npm;

	@SerializedName("nomor_anggota")
	private String nomorAnggota;

	@SerializedName("id_jurusan")
	private String idJurusan;

	@SerializedName("email")
	private String email;

	@SerializedName("nomor_hp")
	private String nomorHp;

	public DataAnggota(DataAnggota dataAnggota) {
		this.namaLengkap = dataAnggota.getNamaLengkap();
		this.npm = dataAnggota.getNpm();
		this.nomorAnggota = dataAnggota.getNomorAnggota();
		this.idJurusan = dataAnggota.getIdJurusan();
		this.email = dataAnggota.getEmail();
		this.nomorHp = dataAnggota.getNomorHp();
	}

	public String getNamaLengkap(){
		return namaLengkap;
	}

	public String getNpm(){
		return npm;
	}

	public String getNomorAnggota(){
		return nomorAnggota;
	}

	public String getIdJurusan(){
		return idJurusan;
	}

	public String getEmail(){
		return email;
	}

	public String getNomorHp(){
		return nomorHp;
	}
}