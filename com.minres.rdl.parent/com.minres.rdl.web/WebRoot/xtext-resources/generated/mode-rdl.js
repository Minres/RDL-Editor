define(["ace/lib/oop", "ace/mode/text", "ace/mode/text_highlight_rules"], function(oop, mText, mTextHighlightRules) {
	var HighlightRules = function() {
		var keywords = "UNDEFINED|UNSPECIFIED|accesswidth|activehigh|activelow|addressing|addrmap|alias|alignment|all|anded|arbiter|async|bigendian|boolean|bothedge|bridge|clock|compact|component|counter|cpuif_reset|decr|decrsaturate|decrthreshold|decrvalue|decrwidth|default|desc|dontcompare|donttest|enable|encode|enum|errextbus|external|false|field|field_reset|fieldwidth|fullalign|halt|haltenable|haltmask|hw|hwclr|hwenable|hwmask|hwset|incr|incrvalue|incrwidth|internal|intr|level|littleendian|lsb0|mask|msb0|na|name|negedge|next|nonsticky|number|ored|overflow|posedge|precedence|property|r|rclr|ref|reg|regalign|regfile|regwidth|reset|resetsignal|rset|rsvdset|rsvdsetX|rw|saturate|shared|sharedextbus|signal|signalwidth|singlepulse|sticky|stickybit|string|sw|swacc|swmod|swwe|swwel|sync|threshold|true|type|underflow|w|we|wel|woclr|woset|wr|xored";
		this.$rules = {
			"start": [
				{token: "lparen", regex: "[\\[{]"},
				{token: "rparen", regex: "[\\]}]"},
				{token: "keyword", regex: "\\b(?:" + keywords + ")\\b"}
			]
		};
	};
	oop.inherits(HighlightRules, mTextHighlightRules.TextHighlightRules);
	
	var Mode = function() {
		this.HighlightRules = HighlightRules;
	};
	oop.inherits(Mode, mText.Mode);
	Mode.prototype.$id = "xtext/rdl";
	Mode.prototype.getCompletions = function(state, session, pos, prefix) {
		return [];
	}
	
	return {
		Mode: Mode
	};
});
