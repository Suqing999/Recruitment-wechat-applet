package com.wx.service.impl;



import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.wx.pojo.Company;
import com.wx.pojo.Companypic;
import com.wx.mapper.CompanyMapper;
import com.wx.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {
	@Resource
	private CompanyMapper companyMapper;

	@Override
	public List<Company> showXX() {
		return companyMapper.selXX();
	}

	@Override
	public List<Company> showFL() {
		return companyMapper.selFL();
	}

	@Override
	public int up1(String xiangxi) {
		
		return companyMapper.up1(xiangxi);
	}

	@Override
	public Company showAll() {
		// TODO Auto-generated method stub
		return companyMapper.showAll();
	}

	@Override
	public int up2(String fuli) {
		// TODO Auto-generated method stub
		return companyMapper.up2(fuli);
	}

	@Override
	public List<Companypic> selPic() {
		// TODO Auto-generated method stub
		return companyMapper.selpic();
	}

	@Override
	public List<Company> showYW() {
		// TODO Auto-generated method stub
		return companyMapper.selyw();
	}

	@Override
	public int upYW(String yewu) {
		// TODO Auto-generated method stub
		return companyMapper.up3(yewu);
	}

	@Override
	public List<Company> showJL() {
		// TODO Auto-generated method stub
		return companyMapper.showJL();
	}

	@Override
	public int upJJ(String jianjie) {
		// TODO Auto-generated method stub
		return companyMapper.upjj(jianjie);
	}

}
