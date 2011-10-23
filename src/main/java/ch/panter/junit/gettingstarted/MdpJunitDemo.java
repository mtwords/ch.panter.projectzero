package ch.panter.junit.gettingstarted;

public class MdpJunitDemo implements IMdpJunitDemo {

	@Override
	public boolean isEmpty(String s) {
		return (s == null || s.length() == 0);
	}

	@Override
	public String capitalize(String s) {
		StringBuilder sb = new StringBuilder();
		char[] chars = s.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (i == 0) {
				sb.append(Character.toUpperCase(chars[i]));
			} else {
				sb.append(Character.toLowerCase(chars[i]));
			}
		}
		return sb.toString();
	}

	@Override
	public String reverse(String s) throws NullPointerException {
		StringBuilder sb = new StringBuilder();
		char[] chars = s.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (Character.isUpperCase(chars[i])) {
				sb.append(Character.toLowerCase(chars[i]));
			} else {
				sb.append(Character.toUpperCase(chars[i]));
			}
		}
		return sb.toString();
	}

	@Override
	public String join(String... strings) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < strings.length; i++) {
			sb.append(strings[i]);
			if (i != strings.length-1) {
				sb.append(" ");
			}
		}
		return sb.toString();
	}

}
