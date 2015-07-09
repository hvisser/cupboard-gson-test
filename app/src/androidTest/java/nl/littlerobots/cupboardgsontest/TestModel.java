package nl.littlerobots.cupboardgsontest;

import com.google.gson.annotations.SerializedName;

import nl.qbusict.cupboard.annotation.Column;

public class TestModel {

    @Column("_id")
    private Long id;
    @SerializedName("server_id")
    private Long serverId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getServerId() {
        return serverId;
    }

    public void setServerId(Long serverId) {
        this.serverId = serverId;
    }
}

