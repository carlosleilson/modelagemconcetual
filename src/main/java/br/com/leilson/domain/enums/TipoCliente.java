package br.com.leilson.domain.enums;

public enum TipoCliente {
	PESSOAFISICA(1,"Pessoa Fisica"),
	PESSOAJURIDICA(2, "Pessoa Juridica");
	
	private int id;
	private String descricao;
	private TipoCliente(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}
	public int getId() {
		return id;
	}
	public String getDescricao() {
		return descricao;
	}
	public static TipoCliente toNum(Integer id) {
		if(id!=null) {
			for(TipoCliente x:TipoCliente.values()) {
				if(x.id==id) {
					return x;
				}
			}
		}
		return null;
	}
}
