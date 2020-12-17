package gameClient;

import api.directed_weighted_graph;
import api.edge_data;
import api.geo_location;
import api.node_data;
import com.google.gson.Gson;
import gameClient.util.Point3D;
import org.json.JSONObject;

import java.util.Objects;

public class CL_Agent {
    private int _id;
    private boolean isOnEdge=false;
    private geo_location _pos;
    private double _speed;
    private edge_data _curr_edge;
    private node_data _curr_node;
    private directed_weighted_graph _gg;
    private CL_Pokemon _curr_fruit;
    private long _sg_dt;

    private double _value;


    public CL_Agent(directed_weighted_graph g, int start_node) {
        _gg = g;
        setMoney(0);
        this._curr_node = _gg.getNode(start_node);
        _pos = _curr_node.getLocation();
        _id = -1;
        setSpeed(0);
    }

    public void update(String json) {
        JSONObject line;
        try {
            line = new JSONObject(json);
            JSONObject ttt = line.getJSONObject("Agent");
            int id = ttt.getInt("id");
            if (id == this.getID() || this.getID() == -1) {
                if (this.getID() == -1) {
                    _id = id;
                }
                double speed = ttt.getDouble("speed");
                String p = ttt.getString("pos");
                Point3D pp = new Point3D(p);
                int src = ttt.getInt("src");
                int dest = ttt.getInt("dest");
                double value = ttt.getDouble("value");
                this._pos = pp;
                this.setCurrNode(src);
                this.setSpeed(speed);
                this.setNextNode(dest);
                this.setMoney(value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getSrcNode() {
        return this._curr_node.getKey();
    }

    public String toJSON() {
        Gson gson = new Gson();
        String ans = gson.toJson(this);
        return ans;
    }

    private void setMoney(double v) {
        _value = v;
    }

    public boolean setNextNode(int dest) {
        boolean ans = false;
        int src = this._curr_node.getKey();
        this._curr_edge = _gg.getEdge(src, dest);
        if (_curr_edge != null) {
            ans = true;
        } else {
            _curr_edge = null;
        }
        return ans;
    }
    public boolean getOnEdge(){
        return this.isOnEdge;
    }
    public void setOnEdge(boolean oe){
        this.isOnEdge=oe;
    }

    public void setCurrNode(int src) {
        this._curr_node = _gg.getNode(src);
    }

    public String toString() {
        return toJSON();
    }

    public int getID() {
        // TODO Auto-generated method stub
        return this._id;
    }

    public geo_location getLocation() {
        return _pos;
    }


    public double getValue() {
        return this._value;
    }


    public int getNextNode() {
        int ans = -2;
        if (this._curr_edge == null) {
            ans = -1;
        } else {
            ans = this._curr_edge.getDest();
        }
        return ans;
    }

    public double getSpeed() {
        return this._speed;
    }

    public void setSpeed(double v) {
        this._speed = v;
    }

    public CL_Pokemon get_curr_fruit() {
        return _curr_fruit;
    }

    public void set_SDT(long ddtt) {
        long ddt = ddtt;
        if (this._curr_edge != null) {
            double w = get_curr_edge().getWeight();
            geo_location dest = _gg.getNode(get_curr_edge().getDest()).getLocation();
            geo_location src = _gg.getNode(get_curr_edge().getSrc()).getLocation();
            double de = src.distance(dest);
            double dist = _pos.distance(dest);
            if (this.get_curr_fruit().get_edge() == this.get_curr_edge()) {
                dist = _curr_fruit.getLocation().distance(this._pos);
            }
            double norm = dist / de;
            double dt = w * norm / this.getSpeed();
            ddt = (long) (1000.0 * dt);
        }
        this.set_sg_dt(ddt);
    }

    public edge_data get_curr_edge() {
        return this._curr_edge;
    }

    public long get_sg_dt() {
        return _sg_dt;
    }

    public void set_sg_dt(long _sg_dt) {
        this._sg_dt = _sg_dt;
    }

    @Override
    public boolean equals(Object o) {
        if(o==null)return false;
        if (this == o) return true;
        if (!(o instanceof CL_Agent)) return false;
        CL_Agent cl_agent = (CL_Agent) o;
        return Objects.equals(_pos, cl_agent._pos) &&
                Objects.equals(get_curr_edge(), cl_agent.get_curr_edge()) &&
                Objects.equals(_curr_node, cl_agent._curr_node) &&
                Objects.equals(_gg, cl_agent._gg);
    }

}
