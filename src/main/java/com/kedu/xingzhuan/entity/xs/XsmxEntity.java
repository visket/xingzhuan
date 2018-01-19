package com.kedu.xingzhuan.entity.xs;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.kedu.xingzhuan.utils.annotation.Bind;

/**
 * 线索内容明细
 * @author around
 * @date 2018-1-16
 */
public class XsmxEntity implements Serializable {

	private static final long serialVersionUID = -3106014228971202172L;

	/** 主键ID */
	private String id;

	/** 线索批次表ID（一对多关联） */
    private String xspcId;

	/** 线索模板ID（关联表或字典） */
    private Integer xsmb;

	/** 线索类型（关联字典）  */
    private String xslx;

	/** 枪支弹药详细信息表  */
    private String qzdyxx;

	/** 线索级别 */
    private String xsjb;

	/** 序号 */
    @Bind(vague="序号,")
    private String xhId;

	/** 来源地 */
    @Bind(vague="案件名称、来源,")
    private String lyd;

	/** 交易号 */
    @Bind(vague="交易号")
    private String jyId;

	/** 外部交易号 */
    private String wbjyId;

	/** 交易状态 */
    private String jyzt;

	/** 交易日期 */
    private Date jyrq;

	/** 合作伙伴ID */
    private String hzhbId;

	/** 交易类型 */
    private String jylx;

	/** 交易金额 */
    private String jyje;

	/** 商品名称 */
    private String spmc;

	/** 收款时间 */
    private Date sksj;

	/** 最后修改时间 */
    private Date zhxgsj;

	/** 对应的协查数据 */
    private String dydcxsj;

	/** 管辖组织 */
    @Bind(vague="单位")
    private String gxzz;

	/** 线索时间 */
    @Bind(vague="线索时间,发布日期,")
    private Date xssj;

	/** 线索内容 */
    private String xsnr;

	/** 关联案件 */
    private String glaj;

	/** 落地人员情况（字典，参考样本—统） */
	@Bind(vague="落地人员情况,")
    private String ldryqk;

	/** 核查进度 */
	@Bind(vague="核查进度,")
    private String hcjd;

	/** 涉案线索具体情况 */
    @Bind(vague="涉案线索具体情况,")
	private String shxsqk;
	
	/** 核查情况 */
    @Bind(vague="核查情况,")
    private String hcqk;

	/** 枪支弹药线索（关联枪支弹药线索表） */
    @Bind(vague="线索枪弹情况,")
    private String xsXsqzdyId;
    
    /** 缴获枪支弹药及零部件情况 */
    @Bind(vague="缴获枪支弹药及零部件情况,")
    private String jhqzdyQkId;

	/** 处理结果 */
    @Bind(vague="处理结果,")
    private String cljg;

	/** 备注 */
    @Bind(vague="备注,")
    private String bj;

	/** 买家用户ID */
    private String mjId;

	/** 买家账户 */
    @Bind(vague="卖家微信号及昵称")
    private String mjZh;

	/** 买家昵称 */
    private String mjNc;

	/** 买家QQ登陆IP */
    private String mjQqDlIp;

	/** 买家QQ登陆省市 */
    private String mjQqDlSs;

	/** 卖家用户ID */
    private String mjyhId;

	/** 卖家账户 */
    private String mjzh;

	/** 卖家昵称 */
    private String mjnc;

	/** 卖家QQ登陆IP */
    private String mjqqdlip;

	/** 卖家QQ登陆省市 */
    private String mjqqdlss;

	/** 物流公司 */
    private String wlgs;

	/** 物流单号 */
    private String wlId;

	/** 收寄点物流公司 */
    private String sjdwlgs;

	/** 寄件人 */
    private String jjr;

	/** 寄件人电话 */
    private BigDecimal jjrCell;

	/** 收件人 */
    private String sjr;

	/** 收件人电话 */
    private BigDecimal sjrCell;

	/** 发货时间 */
    private Date fhsj;

	/** 寄件地址 */
    private String jjdz;

	/** 收货地址 */
    @Bind(vague="买家地址")
    private String shdz;

	/** 省 */
    private String province;

	/** 市 */
    private String city;

	/** 区 */
    private String area;

	/** 创建人 */
    private String cjr;
    
    /** 创建时间 */
    private Date cjsj;

	/** 修改人 */
    private String xgr;

	/** 修改时间 */
    private Date xgsj;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getXspcId() {
        return xspcId;
    }

    public void setXspcId(String xspcId) {
        this.xspcId = xspcId == null ? null : xspcId.trim();
    }

    public Integer getXsmb() {
        return xsmb;
    }

    public void setXsmb(Integer xsmb) {
        this.xsmb = xsmb;
    }

    public String getXslx() {
        return xslx;
    }

    public void setXslx(String xslx) {
        this.xslx = xslx == null ? null : xslx.trim();
    }

    public String getQzdyxx() {
        return qzdyxx;
    }

    public void setQzdyxx(String qzdyxx) {
        this.qzdyxx = qzdyxx == null ? null : qzdyxx.trim();
    }

    public String getXsjb() {
        return xsjb;
    }

    public void setXsjb(String xsjb) {
        this.xsjb = xsjb == null ? null : xsjb.trim();
    }

    public String getXhId() {
        return xhId;
    }

    public void setXhId(String xhId) {
        this.xhId = xhId == null ? null : xhId.trim();
    }

    public String getLyd() {
        return lyd;
    }

    public void setLyd(String lyd) {
        this.lyd = lyd == null ? null : lyd.trim();
    }

    public String getJyId() {
        return jyId;
    }

    public void setJyId(String jyId) {
        this.jyId = jyId == null ? null : jyId.trim();
    }

    public String getWbjyId() {
        return wbjyId;
    }

    public void setWbjyId(String wbjyId) {
        this.wbjyId = wbjyId == null ? null : wbjyId.trim();
    }

    public String getJyzt() {
        return jyzt;
    }

    public void setJyzt(String jyzt) {
        this.jyzt = jyzt == null ? null : jyzt.trim();
    }

    public Date getJyrq() {
        return jyrq;
    }

    public void setJyrq(Date jyrq) {
        this.jyrq = jyrq;
    }

    public String getHzhbId() {
        return hzhbId;
    }

    public void setHzhbId(String hzhbId) {
        this.hzhbId = hzhbId == null ? null : hzhbId.trim();
    }

    public String getJylx() {
        return jylx;
    }

    public void setJylx(String jylx) {
        this.jylx = jylx == null ? null : jylx.trim();
    }

    public String getJyje() {
        return jyje;
    }

    public void setJyje(String jyje) {
        this.jyje = jyje == null ? null : jyje.trim();
    }

    public String getSpmc() {
        return spmc;
    }

    public void setSpmc(String spmc) {
        this.spmc = spmc == null ? null : spmc.trim();
    }

    public Date getSksj() {
        return sksj;
    }

    public void setSksj(Date sksj) {
        this.sksj = sksj;
    }

    public Date getCjsj() {
        return cjsj;
    }

    public void setCjsj(Date cjsj) {
        this.cjsj = cjsj;
    }

    public Date getZhxgsj() {
        return zhxgsj;
    }

    public void setZhxgsj(Date zhxgsj) {
        this.zhxgsj = zhxgsj;
    }

    public String getDydcxsj() {
        return dydcxsj;
    }

    public void setDydcxsj(String dydcxsj) {
        this.dydcxsj = dydcxsj == null ? null : dydcxsj.trim();
    }

    public String getGxzz() {
        return gxzz;
    }

    public void setGxzz(String gxzz) {
        this.gxzz = gxzz == null ? null : gxzz.trim();
    }

    public Date getXssj() {
        return xssj;
    }

    public void setXssj(Date xssj) {
        this.xssj = xssj;
    }

    public String getXsnr() {
        return xsnr;
    }

    public void setXsnr(String xsnr) {
        this.xsnr = xsnr == null ? null : xsnr.trim();
    }

    public String getGlaj() {
        return glaj;
    }

    public void setGlaj(String glaj) {
        this.glaj = glaj == null ? null : glaj.trim();
    }

    public String getLdryqk() {
        return ldryqk;
    }

    public void setLdryqk(String ldryqk) {
        this.ldryqk = ldryqk == null ? null : ldryqk.trim();
    }

    public String getHcjd() {
        return hcjd;
    }

    public void setHcjd(String hcjd) {
        this.hcjd = hcjd == null ? null : hcjd.trim();
    }

    public String getHcqk() {
        return hcqk;
    }

    public void setHcqk(String hcqk) {
        this.hcqk = hcqk == null ? null : hcqk.trim();
    }

    public String getXsXsqzdyId() {
        return xsXsqzdyId;
    }

    public void setXsXsqzdyId(String xsXsqzdyId) {
        this.xsXsqzdyId = xsXsqzdyId == null ? null : xsXsqzdyId.trim();
    }

    public String getCljg() {
        return cljg;
    }

    public void setCljg(String cljg) {
        this.cljg = cljg == null ? null : cljg.trim();
    }

    public String getBj() {
        return bj;
    }

    public void setBj(String bj) {
        this.bj = bj == null ? null : bj.trim();
    }

    public String getMjId() {
        return mjId;
    }

    public void setMjId(String mjId) {
        this.mjId = mjId == null ? null : mjId.trim();
    }

    public String getMjZh() {
        return mjZh;
    }

    public void setMjZh(String mjZh) {
        this.mjZh = mjZh == null ? null : mjZh.trim();
    }

    public String getMjNc() {
        return mjNc;
    }

    public void setMjNc(String mjNc) {
        this.mjNc = mjNc == null ? null : mjNc.trim();
    }

    public String getMjQqDlIp() {
        return mjQqDlIp;
    }

    public void setMjQqDlIp(String mjQqDlIp) {
        this.mjQqDlIp = mjQqDlIp == null ? null : mjQqDlIp.trim();
    }

    public String getMjQqDlSs() {
        return mjQqDlSs;
    }

    public void setMjQqDlSs(String mjQqDlSs) {
        this.mjQqDlSs = mjQqDlSs == null ? null : mjQqDlSs.trim();
    }

    public String getMjyhId() {
        return mjyhId;
    }

    public void setMjyhId(String mjyhId) {
        this.mjyhId = mjyhId == null ? null : mjyhId.trim();
    }

    public String getMjzh() {
        return mjzh;
    }

    public void setMjzh(String mjzh) {
        this.mjzh = mjzh == null ? null : mjzh.trim();
    }

    public String getMjnc() {
        return mjnc;
    }

    public void setMjnc(String mjnc) {
        this.mjnc = mjnc == null ? null : mjnc.trim();
    }

    public String getMjqqdlip() {
        return mjqqdlip;
    }

    public void setMjqqdlip(String mjqqdlip) {
        this.mjqqdlip = mjqqdlip == null ? null : mjqqdlip.trim();
    }

    public String getMjqqdlss() {
        return mjqqdlss;
    }

    public void setMjqqdlss(String mjqqdlss) {
        this.mjqqdlss = mjqqdlss == null ? null : mjqqdlss.trim();
    }

    public String getWlgs() {
        return wlgs;
    }

    public void setWlgs(String wlgs) {
        this.wlgs = wlgs == null ? null : wlgs.trim();
    }

    public String getWlId() {
        return wlId;
    }

    public void setWlId(String wlId) {
        this.wlId = wlId == null ? null : wlId.trim();
    }

    public String getSjdwlgs() {
        return sjdwlgs;
    }

    public void setSjdwlgs(String sjdwlgs) {
        this.sjdwlgs = sjdwlgs == null ? null : sjdwlgs.trim();
    }

    public String getJjr() {
        return jjr;
    }

    public void setJjr(String jjr) {
        this.jjr = jjr == null ? null : jjr.trim();
    }

    public BigDecimal getJjrCell() {
        return jjrCell;
    }

    public void setJjrCell(BigDecimal jjrCell) {
        this.jjrCell = jjrCell;
    }

    public String getSjr() {
        return sjr;
    }

    public void setSjr(String sjr) {
        this.sjr = sjr == null ? null : sjr.trim();
    }

    public BigDecimal getSjrCell() {
        return sjrCell;
    }

    public void setSjrCell(BigDecimal sjrCell) {
        this.sjrCell = sjrCell;
    }

    public Date getFhsj() {
        return fhsj;
    }

    public void setFhsj(Date fhsj) {
        this.fhsj = fhsj;
    }

    public String getJjdz() {
        return jjdz;
    }

    public void setJjdz(String jjdz) {
        this.jjdz = jjdz == null ? null : jjdz.trim();
    }

    public String getShdz() {
        return shdz;
    }

    public void setShdz(String shdz) {
        this.shdz = shdz == null ? null : shdz.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getCjr() {
        return cjr;
    }

    public void setCjr(String cjr) {
        this.cjr = cjr == null ? null : cjr.trim();
    }

    public String getXgr() {
        return xgr;
    }

    public void setXgr(String xgr) {
        this.xgr = xgr == null ? null : xgr.trim();
    }

    public Date getXgsj() {
        return xgsj;
    }

    public void setXgsj(Date xgsj) {
        this.xgsj = xgsj;
    }

	@Override
	public String toString() {
		return "XsmxEntity [id=" + id + ", xspcId=" + xspcId + ", xsmb=" + xsmb + ", xslx=" + xslx + ", qzdyxx="
				+ qzdyxx + ", xsjb=" + xsjb + ", xhId=" + xhId + ", lyd=" + lyd + ", jyId=" + jyId + ", wbjyId="
				+ wbjyId + ", jyzt=" + jyzt + ", jyrq=" + jyrq + ", hzhbId=" + hzhbId + ", jylx=" + jylx + ", jyje="
				+ jyje + ", spmc=" + spmc + ", sksj=" + sksj + ", zhxgsj=" + zhxgsj + ", dydcxsj=" + dydcxsj + ", gxzz="
				+ gxzz + ", xssj=" + xssj + ", xsnr=" + xsnr + ", glaj=" + glaj + ", ldryqk=" + ldryqk + ", hcjd="
				+ hcjd + ", shxsqk=" + shxsqk + ", hcqk=" + hcqk + ", xsXsqzdyId=" + xsXsqzdyId + ", jhqzdyQkId="
				+ jhqzdyQkId + ", cljg=" + cljg + ", bj=" + bj + ", mjId=" + mjId + ", mjZh=" + mjZh + ", mjNc=" + mjNc
				+ ", mjQqDlIp=" + mjQqDlIp + ", mjQqDlSs=" + mjQqDlSs + ", mjyhId=" + mjyhId + ", mjzh=" + mjzh
				+ ", mjnc=" + mjnc + ", mjqqdlip=" + mjqqdlip + ", mjqqdlss=" + mjqqdlss + ", wlgs=" + wlgs + ", wlId="
				+ wlId + ", sjdwlgs=" + sjdwlgs + ", jjr=" + jjr + ", jjrCell=" + jjrCell + ", sjr=" + sjr
				+ ", sjrCell=" + sjrCell + ", fhsj=" + fhsj + ", jjdz=" + jjdz + ", shdz=" + shdz + ", province="
				+ province + ", city=" + city + ", area=" + area + ", cjr=" + cjr + ", cjsj=" + cjsj + ", xgr=" + xgr
				+ ", xgsj=" + xgsj + "]";
	}
    
    
}