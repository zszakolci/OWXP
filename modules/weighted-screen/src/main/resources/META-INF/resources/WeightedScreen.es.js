import Component from 'metal-component/src/Component';
import core from 'metal/src/core';
import dom from 'metal-dom/src/dom';
import Soy from 'metal-soy/src/Soy';
import templates from './WeightedScreen.soy';

import * as d3 from 'weighted-screen/js/d3';

class WeightedScreen extends Component {

	attached() {
		window.addEventListener('resize', this.createScreen_.bind(this));
	}

	constructor(opt_config) {
		super(opt_config);

		this.createNodes_();
		this.createScreen_();

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

		let sizes = this.getParentSizes();

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
	            .attr('title',
	                function(d) {
	                    return d.id;
	                })
	            .style('left',
	                function(d) {
	                    return d.x0 + 'px';
	                })
	            .style('top',
	                function(d) {
	                    return d.y0 + 'px';
	                })
	            .style('width',
	                function(d) {
	                    return d.x1 - d.x0 + 'px';
	                })
	            .style('height',
	                function(d) {
	                    return d.y1 - d.y0 + 'px';
	                })
	            .style('line-height',
	                function(d) {
	                    return d.y1 - d.y0 + 'px';
	                })
	            .style('text-align', 'center')
	            .style('background',
	                function(d, i) {
	                    return colors(i);
	                });

	        nodes.append('div')
	            .attr('class', 'node-label caption-defaultWrap')
	            .style('height',
	                function(d) {
	                    return d.y1 - d.y0 + 'px';
	                })
	            .style('width',
	                function(d) {
	                    return d.x1 - d.x0 + 'px';
	                })
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

	createNodes_() {
		let data = [
                { "id": 3, "name": "A Day in the Life of a Product Owner", "views": 148, "url": "https://grow.liferay.com/group/guest/learn/-/wiki/Grow/A+Day+in+the+Life+of+a+Product+Owner" },
                { "id": 4, "name": "Advanced System Architecture", "views": 121, "url": "https://grow.liferay.com/group/guest/learn/-/wiki/Grow/Advanced+System+Architecture" },
                { "id": 5, "name": "Annotations in Liferay portal", "views": 114, "url": "https://grow.liferay.com/group/guest/learn/-/wiki/Grow/Annotations+in+Liferay+portal" },
                { "id": 6, "name": "Basic cluster config", "views": 141, "url": "https://grow.liferay.com/group/guest/learn/-/wiki/Grow/Basic+cluster+config" },
                { "id": 7, "name": "Cloud DB", "views": 155, "url": "https://grow.liferay.com/group/guest/learn/-/wiki/Grow/Cloud+DB" },
                { "id": 2, "name": "Clustering Basics", "views": 147, "url": "https://grow.liferay.com/group/guest/learn/-/wiki/Grow/Clustering+Basics" },
                { "id": 8, "name": "Company Meeting Q video collection", "views": 174, "url": "https://grow.liferay.com/group/guest/learn/-/wiki/Grow/Company+Meeting+Q+video+collection" },
                { "id": 9, "name": "CS & TS workflow", "views": 177, "url": "https://grow.liferay.com/group/guest/learn/-/wiki/Grow/CS+&+TS+workflow" },
                { "id": 10, "name": "Data Dialogs 2016", "views": 185, "url": "https://grow.liferay.com/group/guest/learn/-/wiki/Grow/Data+Dialogs+2016" },
                { "id": 11, "name": "Eclipse Hot Keys", "views": 541, "url": "https://grow.liferay.com/group/guest/learn/-/wiki/Grow/Eclipse+Hot+Keys" }
        ];

		if (this.shuffled) {
            d3.shuffle(data);
        }

        this.nodesRoot = {
            'children': data
        };
    }

    getParentSizes() {
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

// Register component
Soy.register(WeightedScreen, templates);

export default WeightedScreen;