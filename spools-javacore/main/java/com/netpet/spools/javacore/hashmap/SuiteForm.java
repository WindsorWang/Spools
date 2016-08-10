/*
 * Copyright [2016]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.netpet.spools.javacore.hashmap;

/**
 * ����ʵ�壬ģ���û���ֵ�ײ�ģ��:һ��������+N����չ����N����Ϊ0��
 */
public class SuiteForm {
	
	private boolean isChanged = false;
	
	//�˷ѽ��
	private int refundMoney;
	
	private String refundMoneyStr;
	
	public boolean isChanged() {
		return isChanged;
	}

	public void setChanged(boolean isChanged) {
		this.isChanged = isChanged;
	}

	public int getRefundMoney() {
		return refundMoney;
	}

	public void setRefundMoney(int refundMoney) {
		this.refundMoney = refundMoney;
	}
	
	public void setRefundMoneyByString(String refundMoneyStr) {
		this.refundMoneyStr = refundMoneyStr;
	}
	
	public String getRefundMoneyStr() {
		return refundMoneyStr;
	}
}

