import core from 'metal/src/core';
import Ajax from 'metal-ajax/src/Ajax';
import Component from 'metal-component/src/Component';
import dom from 'metal-dom/src/dom';
import MultiMap from 'metal-multimap/src/MultiMap';
import Soy from 'metal-soy/src/Soy';

import templates from './WeightedScreen.soy';

import * as d3 from 'weighted-screen/js/d3';

class WeightedScreen extends Component {

	attached() {
		window.addEventListener('resize', this.createScreen_.bind(this));
	}

	constructor(opt_config) {
		super(opt_config);

		this.getWikiPagesURL = opt_config.getWikiPagesURL;
		this.portletNamespace = opt_config.portletNamespace;

		this.start = 0;
		this.end = 10;

		this.getWikiPages_();
	}

	createScreen_() {
		let colors = d3.scaleOrdinal()
			.range(
				d3.schemeCategory10.map(
					(c) => {
						c = d3.rgb(c); c.opacity = 0.6; return c;
					}
				)
			);

		let root = d3.hierarchy(this.nodesRoot);

		root.sum(
			function(d) {
				return d.views;
			}
		);

		let sizes = this.getParentSizes_();

		let treemap = d3.treemap()
			.size(
				[sizes.width, this.height]
			)
			.padding(2).paddingInner(15);

		treemap(root);

		let screen = d3.select('#weightedscreen').html('');

		screen.style('min-height', this.height);

		let nodes = screen.selectAll('.node')
			.data(root.leaves())
			.enter()
			.append('div')
			.attr('class', 'node')
			.attr(
				'title',
				function(d) {
					return d.id;
				}
			)
			.style(
				'left',
				function(d) {
					return d.x0 + 'px';
				}
			)
			.style(
				'top',
				function(d) {
					return d.y0 + 'px';
				}
			)
			.style(
				'width',
				function(d) {
					return d.x1 - d.x0 + 'px';
				}
			)
			.style(
				'height',
				function(d) {
					return d.y1 - d.y0 + 'px';
				}
			)
			.style(
				'line-height',
				function(d) {
					return d.y1 - d.y0 + 'px';
				}
			)
			.style('text-align', 'center')
			.style(
				'background',
				function(d, i) {
					return colors(i);
				}
			);

		nodes.append('div')
			.attr('class', 'node-label caption-defaultWrap')
			.style(
				'height',
				function(d) {
					return d.y1 - d.y0 + 'px';
				}
			)
			.style(
				'width',
				function(d) {
					return d.x1 - d.x0 + 'px';
				}
			)
			.style('line-height', 'inherit')
			.append('a')
			.attr(
				'href',
				function(d) {
					return d.data.url;
				}
			)
			.text(
				function(d) {
					return d.data.name;
				}
			);

		nodes.append('div')
			.attr('class', 'caption-defaultWrap')
			.text(
				function(d) {
					return d.data.name;
				}
			);

		d3.selectAll('.node')
			.on(
				'mouseover',
				function() {
					d3.select(this).style('box-shadow', '0px 0px 9px 1px black');
				}
			);

		d3.selectAll('.node')
			.on(
				'mouseout',
				function() {
					d3.select(this).style('box-shadow', 'none');
				}
			);
	}

	createNodes_(data) {
		if (this.shuffled) {
			d3.shuffle(data);
		}

		this.nodesRoot = {
			'children': data
		};
	}

	getParentSizes_() {
		let height = 0;
		let width = 0;

		let hostElement = this.elementValue_;

		if (hostElement.parentNode != null) {
			height = hostElement.parentNode.clientHeight;
			width = hostElement.parentNode.clientWidth;
		}

		return {
			height: height,
			width: width
		};
	}

	getWikiPages_() {
		this.loading = true;

		let opt_params = new MultiMap();

		opt_params.add(this.portletNamespace + 'start', this.start);
		opt_params.add(this.portletNamespace + 'end', this.end);

		Ajax.request(
			this.getWikiPagesURL,
			'GET',
			null,
			null,
			opt_params
		)
		.then((response) => {
			let wikiPages = [];

			if (response.response) {
				wikiPages = JSON.parse(response.response);
			}

			this.createNodes_(wikiPages);

			this.createScreen_();
		});
	}
}

WeightedScreen.STATE = {
	height: {
		value: 500
	},

	nodesNumber: {
		value: 20
	},

	nodesRoot: {
	},

	shuffled: {
		value: true
	}
}

Soy.register(WeightedScreen, templates);

export default WeightedScreen;