package com.minres.rdl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IntegerWithRadix {

	private static final Pattern bin = Pattern.compile("([0-9]+)?'b([01_]+)");
	private static final Pattern oct = Pattern.compile("([0-9]+)?'o([0-7_]+)");
	private static final Pattern dec = Pattern.compile("([0-9]+)?'d([0-9_]+)");
	private static final Pattern hex = Pattern.compile("([0-9]+)?'h([0-9a-fA-F_]+)");

	public long value;
	public int length;
	public int radix;
	

	public IntegerWithRadix(Integer valueOf) {
		this.value=valueOf;
		this.radix=10;
		this.length=0;
	}
	public IntegerWithRadix(Integer valueOf, int radix) {
		this.value=valueOf;
		this.radix=radix;
		this.length=0;
	}

	public IntegerWithRadix(Integer valueOf, int radix, int len) {
		this.value=valueOf;
		this.radix=radix;
		this.length=len;
	}

	public IntegerWithRadix(String string) {
		radix=10;
		if(string.contains("'")){
			Matcher matcher=hex.matcher(string);
			if(matcher.matches()){
				radix = 16;
				if(matcher.groupCount()==2){
					length=Integer.valueOf(matcher.group(1));
					string=matcher.group(2).replaceAll("_", "");
				} else
					string=matcher.group(1).replaceAll("_", "");
				value=Long.parseLong(string, radix);
			}
			matcher =bin.matcher(string);
			if(matcher.matches()){
				radix = 2;
				if(matcher.groupCount()==2){
					length=Integer.valueOf(matcher.group(1));
					string=matcher.group(2).replaceAll("_", "");
				} else
					string=matcher.group(1).replaceAll("_", "");
				value=Long.parseLong(string, radix);
			} 
			matcher =dec.matcher(string);
			if(matcher.matches()){
				radix = 10;
				if(matcher.groupCount()==2){
					length=Integer.valueOf(matcher.group(1));
					string=matcher.group(2).replaceAll("_", "");
				} else
					string=matcher.group(1).replaceAll("_", "");
				value=Long.parseLong(string, radix);
			}
			matcher =oct.matcher(string);
			if(matcher.matches()){
				radix = 8;
				if(matcher.groupCount()==2){
					length=Integer.valueOf(matcher.group(1));
					string=matcher.group(2).replaceAll("_", "");
				} else
					string=matcher.group(1).replaceAll("_", "");
				value=Long.parseLong(string, radix);
			}						
		} else if(string.startsWith("0x") || string.startsWith("0X")) {
			radix = 16;
			string = string.substring(2);
		} else if(string.startsWith("0") && string.length()>1) {
			radix=8;
		}
		value=Long.parseLong(string, radix);
	}

	public String toString(){
		StringBuilder sb = new StringBuilder();
		if(length>0){
			sb.append(length);
			switch(radix){
			case 16:
				sb.append("'h").append(Long.toHexString(value));
				break;
			case 8:
				sb.append("'o").append(Long.toOctalString(value));
				break;
			case 2:
				sb.append("'b").append(Long.toBinaryString(value));
				break;
			default:
				sb.append("'d").append(value);
				break;
			}
		} else{
			switch(radix){
			case 16:
				sb.append("0x").append(Long.toHexString(value));
				break;
			case 8:
				sb.append("0").append(Long.toOctalString(value));
				break;
			default:
				sb.append(value);
				break;
			}			
		}
		return sb.toString();
	}
}

